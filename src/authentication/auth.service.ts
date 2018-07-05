import * as jwt from 'jsonwebtoken';

import {Component} from '@nestjs/common';
import {StudentService} from "../service/student.service";
import {EncryptorService} from "./encryptor/encryptor.service";

@Component()
export class AuthService {
    constructor(private readonly studentService: StudentService) {}

    async createToken(student) {
        //1 month in min
        const expiresIn = 60 * 60;
        const secretOrKey = 'secret';
        const token = jwt.sign(student, secretOrKey, { expiresIn });

        return {
            expires_in: expiresIn,
            access_token: token,
        };
    }

    async validateStudent(signedStudent): Promise<boolean> {
        const { mail, password } = signedStudent;
        const student = await this.studentService.findOneByMail(mail);

        return await EncryptorService.validate(password, student.password);
    }
}