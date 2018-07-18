import {BadRequestException, Body, Controller, Post} from '@nestjs/common';
import {AuthService} from "./auth.service";
import {StudentService} from '../service/student.service';
import {Student} from '../entity/student.entity';
import {EncryptorService} from "./encryptor/encryptor.service";

@Controller('auth')
export class AuthController {
    constructor(
        private readonly authService: AuthService,
        private readonly studentService: StudentService,
    ) {}


    @Post()
    public async authStudent(@Body() studentRequest: Student) {
        const { mail, password } = studentRequest;
        const student = await this.studentService.findOneByMail(mail);

        if (student) {
            const result = await EncryptorService.validate(password, student.password);
            if (result) {
                const tokenPayload = {
                    mail: student.mail,
                    role: student.role,
                };
                return await this.authService.createToken(tokenPayload);
            }
        }
        throw new BadRequestException('Invalid credentials');
    }

}

