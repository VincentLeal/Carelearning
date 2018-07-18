import {Body, Controller, Delete, Get, Param, Post, Put, Req} from '@nestjs/common';
import {Exercise} from '../entity/exercise.entity';
import {ExerciseService} from '../service/exercise.service';
import {RoleVerificator} from '../authentication/role.verificator';

@Controller('exercise')
export class ExerciseController {
    private readonly roleVerificator: RoleVerificator;

    constructor(private readonly exerciseService: ExerciseService) {
        this.roleVerificator = new RoleVerificator('admin');
    }
    @Get()
    async findAll(): Promise<Exercise[]> {
        return await this.exerciseService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.exerciseService.findOne(+id);
    }

    @Post()
    async create(@Body() exercise: Exercise) {
        const createdExercise = await this.exerciseService.create(exercise);
        return { exercise: createdExercise };
    }

    @Put(':id')
    async update(@Req() request, @Param('id') id: string, @Body() exercise: Partial<Exercise>) {
        console.log(request.user);

        this.roleVerificator.verify(request.user);

        return await this.exerciseService.update(+id, exercise);
    }

    @Delete(':id')
    async  destroy(@Req() request, @Param('id') id: string) {
        console.log(request.user);

        this.roleVerificator.verify(request.user);
        await this.exerciseService.destroy(+id);
        return;
    }

}