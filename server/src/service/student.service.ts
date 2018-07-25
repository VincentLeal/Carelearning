import {Component, ForbiddenException} from '@nestjs/common';
import {Student} from '../entity/student.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from 'typeorm';
import {ConflictException} from '@nestjs/common/exceptions/conflict.exception';
import {MailSender} from '../mail/send.mail';

@Component()
export class StudentService {
    private readonly mailSender: MailSender;

    constructor(
        @InjectRepository(Student)
        private readonly studentRepository: Repository<Student>,
    ) {
        this.mailSender = new MailSender();
    }

    async findAll(): Promise<Student[]> {
        return await this.studentRepository.find();
    }

    async findOne(id: number): Promise<Student>{
        return await this.studentRepository.findOneById(id);
    }

    async findOneByMail(mail: string): Promise<Student>{
        return await this.studentRepository.findOne( {mail});
    }

    async create(student: Student) {
        const studentFromDB = await this.findOneByMail(student.mail);
        const studentAlreadyExist = studentFromDB != null;
        if (studentAlreadyExist) {
            throw new ConflictException();
        }

        if (student.role === 'user') {
            student.password = Math.random().toString(20).substring(2, 15);
            const context = {
                username: student.firstname,
                password: student.password,
                mailTo: student.mail,
            };
            this.mailSender.sendMail(MailSender.MAIL_TEMPLATE.SEND_PASSWORD, context);
        }

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