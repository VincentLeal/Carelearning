import {Body, Controller, Delete, Get, Param, Patch, Post} from "@nestjs/common";
import {Revision_user} from "../entity/revision_user.entity";

@Controller('revision_user')
export class Revision_userController {
    constructor(private readonly revision_userService: Revision_userService) {}
    @Get()
    async findAll(): Promise<Revision_user> {
        return await this.revision_userService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.revision_userService.findOne(+id);
    }

    @Post()
    async create(@Body() revision_user: Revision_user) {
        const createdRevision_user = await this.revision_userService.create(revision_user);
        return { reivision_user: createdRevision_user };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() revision_user: Partial<Revision_user>) {
        return await this.revision_userService.update(+id, revision_user);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        await this.revision_userService.destroy(+id);
        return;
    }
}