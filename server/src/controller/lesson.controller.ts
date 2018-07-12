import {Body, Controller, Delete, Get, Param, Post, Put} from "@nestjs/common";
import {Lesson} from "../entity/lesson";
import {LessonService} from "../service/lesson.service";

@Controller('lesson')
export class LessonController {
    constructor(private readonly lessonService: LessonService) {}
    @Get()
    async findAll(): Promise<Lesson[]> {
        return await this.lessonService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.lessonService.findOne(+id);
    }

    @Post()
    async create(@Body() lesson: Lesson) {
        const createdLesson = await this.lessonService.create(lesson);
        console.log(lesson);
        return { lesson: createdLesson };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body() lesson: Partial<Lesson>) {
        return await this.lessonService.update(+id, lesson);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.lessonService.destroy(+id);
        return;
    }

}