import {Body, Controller, Post, UsePipes} from '@nestjs/common';
import {StudentService} from '../service/student.service';
import {Student} from '../entity/student.entity';
import {DeSerializationPipe} from '../authentication/pipes/DeSerializationPipe';

@Controller('poststudent')
export class PostStudentController {
    constructor(private readonly studentService: StudentService) {}

    @Post()
    @UsePipes(new DeSerializationPipe())
    async create(@Body() student: Student){
        const createdStudent = await this.studentService.create(student);
        return { student: createdStudent };
    }
}