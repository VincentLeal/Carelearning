import {Body, Controller, Delete, Get, Param, Patch, Post} from "@nestjs/common";
import { RevisionSheet } from "../entity/revision_sheet.entity";
import {RevisionSheetService} from "../service/revision_sheet.service";

@Controller('revision_sheet')
export class RevisionSheetController {
    constructor(private readonly revisionSheetService: RevisionSheetService) {}
    @Get()
    async findAll(): Promise<RevisionSheet[]> {
        return await this.revisionSheetService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.revisionSheetService.findOne(+id);
    }

    @Post()
    async create(@Body() revisionSheet: RevisionSheet) {
        const createdRevisionSheet = await this.revisionSheetService.create(revisionSheet);
        return { revisionSheet: createdRevisionSheet };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() revisionSheet: Partial<RevisionSheet>) {
        return await this.revisionSheetService.update(+id, revisionSheet);
    }

    @Delete(':id')
    async  destroy(@Param('id') id: string) {
        await this.revisionSheetService.destroy(+id);
        return;
    }

}