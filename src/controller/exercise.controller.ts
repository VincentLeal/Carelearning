import {Body, Controller, Delete, Get, Param, Patch, Post} from '@nestjs/common';
import {Exercise} from '../entity/exercise.entity';
import {ExerciseService} from "../service/exercise.service";

@Controller('exercise')
export class ExerciseController {
    constructor(private readonly exerciseService: ExerciseService) {}
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

    @Patch(':id')
    async update(@Param('id') id: string, @Body() exercise: Partial<Exercise>) {
        return await this.exerciseService.update(+id, exercise);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.exerciseService.destroy(+id);
        return;
    }

}