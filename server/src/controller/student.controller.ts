import {Body, Controller, Delete, Get, Param, Post, Put, Req, Res, UsePipes} from '@nestjs/common';
import {Student} from '../entity/student.entity';
import {StudentService} from '../service/student.service';
import {DeSerializationPipe} from '../authentication/pipes/DeSerializationPipe';
import {RoleVerificator} from '../authentication/role.verificator';
import {MailSender} from '../mail/send.mail';

@Controller('student')
export class StudentController {
    private readonly adminRoleVerificator: RoleVerificator;

    constructor(private readonly studentService: StudentService) {
        this.adminRoleVerificator = new RoleVerificator('admin');
    }
    @Get()
    async findAll(@Req() request): Promise<Student[]> {
        this.adminRoleVerificator.verify(request.user);
        return await this.studentService.findAll();
    }

    @Get('/me')
    async findMe(@Req() request){
        return await this.studentService.findOneByMail(request.user.mail);
    }

    @Put(':id')
    async update(@Req() request, @Param('id') id: number, @Body() student: Partial<Student>) {
        this.adminRoleVerificator.verify(request.user);
        return await this.studentService.update(id, student);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string, @Req() request) {
        this.adminRoleVerificator.verify(request.user);
        await this.studentService.destroy(+id);
    }

}
