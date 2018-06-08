import {Body, Controller, Delete, Get, Param, Post, Put} from '@nestjs/common';
import {Result} from '../entity/result.entity';
import {ResultService} from "../service/result.service";

@Controller('result')
export class ResultController{
    constructor(private readonly resultService: ResultService) {}
    @Get()
    async findAll(): Promise<Result[]> {
        return await this.resultService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.resultService.findOne(+id);
    }

    @Post()
    async create(@Body() result: Result) {
        const createdResult = await this.resultService.create(result);
        return { result: createdResult };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body() result: Partial<Result>) {
        return await this.resultService.update(+id, result);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.resultService.destroy(+id);
        return;
    }
}