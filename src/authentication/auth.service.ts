import * as jwt from 'jsonwebtoken';

import { Injectable } from '@nestjs/common';
import { StudentService } from "../service/student.service";
import { JwtPayload } from ''

@Injectable()
export class AuthService {
    constructor(private readonly studentService: StudentService) {}

    async createToken() {
        const student: JwtPayload = { email: 'lucile.1988.ls@gmail.com'};
        return jwt.sign(student, 'secretKey', { expiresIn: 10 });
    }

    async validateStudent(payload: JwtPayload): Promise<any>{
        return await this.studentService.findOneByEmail(payload.email);
    }
}