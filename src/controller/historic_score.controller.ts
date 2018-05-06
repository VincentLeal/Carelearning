import {Body, Controller, Delete, Get, Param, Patch, Post} from "@nestjs/common";
import {Historic_score} from "../entity/historic_score";
import {Historic_scoreService} from "../service/historic_score.service";

@Controller('historic_score')
export class Historic_scoreController {
    constructor(private readonly historic_scoreService: Historic_scoreService) {}
    @Get()
    async findAll(): Promise<Historic_score[]> {
        return await this.historic_scoreService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.historic_scoreService.findOne(+id);
    }

    @Post()
    async create(@Body() historic_score: Historic_score) {
        const createdHistoric_score = await this.historic_scoreService.create(historic_score);
        return { historic_score: createdHistoric_score };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() historic_score: Partial<Historic_score>) {
        return await this.historic_scoreService.update(+id, historic_score);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        await this.historic_scoreService.destroy(+id);
        return;
}
}