import { Strategy } from 'passport-http-bearer';
import { PassportStrategy } from '@nesstjs/passport';
import { Injectable, Unauthorized } from '@nestjs/common';
import { AuthService } from "../service/auth.service";

@Injectable()
export class HttpStrategy extends PassportStrategy(Strategy) {
    constructor(private readonly authService: AuthService) {
        super();
    }

    async validate(token: any, done: Function){
        const student = await this.authService.validateStudent(token);

        if(!student){
            return done(new UnauthorizedExcetpion(), false);
        }
        done(null, student);
    }
}