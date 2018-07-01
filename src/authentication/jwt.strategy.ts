import { Strategy } from 'passport-http-bearer';
import { PassportStrategy } from '@nesstjs/passport';
import { Injectable, UnauthorizedException } from '@nestjs/common';
import { AuthService } from "./auth.service";

@Injectable()
export class JwtStrategy extends PassportStrategy(Strategy) {
    constructor(private readonly authService: AuthService) {
        super();
    }

    async validate(payload: JwtStrategy, done: Function){
        const student = await this.authService.validateStudent(payload);

        if(!student){
            return done(new UnauthorizedException(), false);
        }
        done(null, student);
    }
}