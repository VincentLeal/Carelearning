import {Body, Controller, Delete, Get, Param, Post, Put, Req, Res} from '@nestjs/common';
import {Lesson} from '../entity/lesson';
import {LessonService} from '../service/lesson.service';
import {RoleVerificator} from '../authentication/role.verificator';

@Controller('lesson')
export class LessonController {
    private readonly roleVerificator: RoleVerificator;

    constructor(private readonly lessonService: LessonService) {
        this.roleVerificator = new RoleVerificator('admin');
    }
    @Get()
    async findAll(): Promise<Lesson[]> {
        return await this.lessonService.findAll();
    }

    @Get(':id')
    async findOne(@Res() response, @Param('id') id: string){
        return await this.lessonService.findOne(+id);
    }

    @Post()
    async create(@Req() request, @Body() lesson: Lesson) {
        this.roleVerificator.verify(request.user);

        const createdLesson = await this.lessonService.create(lesson);
        return { lesson: createdLesson };
    }

    @Put(':id')
    async update(@Req() request, @Param('id') id: string, @Body() lesson: Partial<Lesson>) {
        console.log(request.user);
        this.roleVerificator.verify(request.user);
        return await this.lessonService.update(+id, lesson);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.lessonService.destroy(+id);
        return;
    }

}