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
    public async getToken(@Body() credentials: Student) {
        const { mail, password } = credentials;
        const student = await this.studentService.findOneByMail(mail);

        if(student) {
            const result = await EncryptorService.validate(password, student.password);
            if(result) {
                return await this.authService.createToken(credentials);
            }
        }
        throw new BadRequestException('Invalid credentials');
    }

}

