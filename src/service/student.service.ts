import {Component} from '@nestjs/common';
import {Student} from '../entity/student.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from "typeorm";

@Component()
export class StudentService {
    constructor(
        @InjectRepository(Student)
        private readonly studentRepository: Repository<Student>
    ) {}

    async findAll(): Promise<Student[]> {
        return await this.studentRepository.find();
    }

    async findOne(id: number): Promise<Student>{
        return await this.studentRepository.findOneById(id);
    }

    async create(student: Student) {
        return await this.studentRepository.save(student);
    }

    async update(id: number, studentData: Partial<Student>): Promise<Student> {
        await this.studentRepository.updateById(id, studentData);
        return this.studentRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.studentRepository.deleteById(id);
    }
}