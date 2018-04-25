import { Body, Controller, Get, Post, Patch, Param, Delete } from '@nestjs/common';
import { Exercice } from '../entity/exercice.entity';
import {ExerciceService} from "../service/exercice.service";

@Controller('exercice')
export class ExerciceController {
    constructor(private readonly exerciceService: ExerciceService) {}
    @Get()
    async findAll(): Promise<Exercice[]> {
        return await this.exerciceService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.exerciceService.findOne(+id);
    }

    @Post()
    async create(@Body() exercice: Exercice) {
        const createdExercice = await this.exerciceService.create(exercice);
        return { exercice: createdExercice };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() exercice: Partial<Exercice>) {
        return await this.exerciceService.update(+id, exercice);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.exerciceService.destroy(+id);
        return;
    }

}