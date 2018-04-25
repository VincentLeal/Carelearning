import { Body, Controller, Get, Param, Post, Patch, Delete } from '@nestjs/common';
import { User } from '../entity/user.entity';
import {UserService} from "../service/user.service";

@Controller('user')
export class UserController {
    constructor(private readonly userService: UserService) {}
    @Get()
    async findAll(): Promise<User[]> {
        return await this.userService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.userService.findOne(+id);
    }

    @Post()
    async create(@Body() user: User){
        const createdUser = await this.userService.create(user);
        return { user: createdUser };
    }

    @Patch(':id')
    async update(@Param('id') id: string, @Body() user: Partial<User>) {
        return await this.userService.update(+id, user);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        await this.userService.destroy(+id);
        return;
    }

}
