import {Body, Controller, Delete, Get, Param, Post, Put, UsePipes} from '@nestjs/common';
import {Student} from '../entity/student.entity';
import {StudentService} from '../service/student.service';
import {DeSerializationPipe} from '../authentication/pipes/DeSerializationPipe';

@Controller('student')
export class StudentController {
    constructor(private readonly studentService: StudentService) {}
    @Get()
    async findAll(): Promise<Student[]> {
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
        return { student: createdStudent };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body() student: Partial<Student>) {
        return await this.studentService.update(+id, student);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        await this.studentService.destroy(+id);
    }

}
