import {Body, Controller, Delete, Get, Param, Post, Put, Req, UsePipes} from '@nestjs/common';
import {Student} from '../entity/student.entity';
import {StudentService} from '../service/student.service';
import {DeSerializationPipe} from '../authentication/pipes/DeSerializationPipe';
import {RoleVerificator} from '../authentication/role.verificator';
import {SendMail} from '../mail/send.mail';

@Controller('student')
export class StudentController {
    private readonly roleVerificator: RoleVerificator;
    private readonly sendMail: SendMail;

    constructor(private readonly studentService: StudentService) {
        this.roleVerificator = new RoleVerificator('admin');
        this.sendMail = new SendMail();
    }
    @Get()
    async findAll(@Req() request): Promise<Student[]> {
        this.roleVerificator.verify(request.user);
        return await this.studentService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.studentService.findOne(+id);
    }

    @Post()
    @UsePipes(new DeSerializationPipe())
    async create(@Body() student: Student){
        const createdStudent = await this.studentService.create(student);
        this.sendMail.sendMail();
        return { student: createdStudent };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body() student: Partial<Student>) {
        return await this.studentService.update(+id, student);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string, @Req() request) {
        console.log(request.user);

        this.roleVerificator.verify(request.user);

        await this.studentService.destroy(+id);
    }

}
