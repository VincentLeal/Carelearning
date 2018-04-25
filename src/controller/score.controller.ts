import {Body, Controller, Delete, Get, Param, Patch, Post} from '@nestjs/common';
import { Score } from '../entity/score.entity';
import {ScoreService} from "../service/score.service";

@Controller('score')
export class ScoreController{
    constructor(private readonly scoreService: ScoreService) {}
    @Get()
    async findAll(): Promise<Score[]> {
        return await this.scoreService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.scoreService.findOne(+id);
    }

    @Post()
    async create(@Body() score: Score) {
        const createdScore = await this.scoreService.create(score);
        return { score: createdScore };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() score: Partial<Score>) {
        return await this.scoreService.update(+id, score);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.scoreService.destroy(+id);
        return;
    }
}