import {Body, Controller, Delete, Get, Param, Post, Put} from "@nestjs/common";
import {Revision_sheet} from "../entity/revision_sheet.entity";
import {Revision_sheetService} from "../service/revision_sheet.service";

@Controller('revision_sheet')
export class Revision_sheetController {
    constructor(private readonly revision_sheetService: Revision_sheetService) {}
    @Get()
    async findAll(): Promise<Revision_sheet[]> {
        return await this.revision_sheetService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.revision_sheetService.findOne(+id);
    }

    @Post()
    async create(@Body() revision_sheet: Revision_sheet) {
        const createdRevision_sheet = await this.revision_sheetService.create(revision_sheet);
        return { reivision_sheet: createdRevision_sheet };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body() revision_sheet: Partial<Revision_sheet>) {
        return await this.revision_sheetService.update(+id, revision_sheet);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        await this.revision_sheetService.destroy(+id);
        return;
    }
}