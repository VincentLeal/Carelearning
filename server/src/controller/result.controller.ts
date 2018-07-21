import {Body, Controller, Delete, Get, Param, Post, Put, Req} from '@nestjs/common';
import {Result} from '../entity/result.entity';
import {ResultService} from "../service/result.service";
import {RoleVerificator} from '../authentication/role.verificator';

@Controller('result')
export class ResultController{
    private readonly roleVerificator: RoleVerificator;

    constructor(private readonly resultService: ResultService) {
        this.roleVerificator = new RoleVerificator('admin');
    }

    @Get()
    async findAll(@Req() request): Promise<Result[]> {
        return await this.resultService.findAll();
    }

    @Get(':id')
    async findOne(@Req() request, @Param('id') id: string){
        if(request.user.role === 'admin'){
            return await this.resultService.findOne(+id);
        }else{
            const userId = request.user.id;
            return await this.resultService.findOne(+userId);
        }
    }

    @Post()
    async create(@Body() result: Result) {
        const createdResult = await this.resultService.create(result);
        return { result: createdResult };
    }
}