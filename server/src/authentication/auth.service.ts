import * as jwt from 'jsonwebtoken';

import {Component} from '@nestjs/common';
import {StudentService} from '../service/student.service';
import {EncryptorService} from './encryptor/encryptor.service';

@Component()
export class AuthService {
    constructor(private readonly studentService: StudentService) {}

    async createToken(payload) {
        //1 month in min
        const expiresIn = 60 * 730;
        const secretOrKey = 'secret';
        const token = jwt.sign(payload, secretOrKey, { expiresIn });

        return {
            expires_in: expiresIn,
            access_token: token,
        };
    }

    async defineRole(signedStudent): Promise<string> {
        const { mail, role } = signedStudent;
        const student = await this.studentService.findOneByMail(mail);


        if(role === 'admin')
            return 'admin';
        return 'user';
        //return await EncryptorService.validate(password, student.password);
    }
}