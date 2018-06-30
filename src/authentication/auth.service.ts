import { Injectable } from '@nestjs/common';
import { StudentService } from "./student.service";

@Injectable()
export class AuthService {
    constructor(private readonly studentService: StudentService) {}

    async validateStudent(token: string): Promise<any>{
        return await this.studentService.findOneByToken(token);
    }
}