import * as passport from 'passport';

import { ExtractJwt, Strategy } from 'passport-jwt';

import { Component, UnauthorizedException } from '@nestjs/common';
import { AuthService } from "../auth.service";

@Component()
export class JwtStrategy extends Strategy {
    constructor(private readonly authService: AuthService) {
        super(
            {
                jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
                passReqToCallback: true,
                secretOrKey: 'secret'
            },
            async (req, payload, next) => await this.verify(req, payload, next),
        );
        passport.use(this);
    }

    async verify(req, payload, done){
        const isValid = await this.authService.validateStudent(payload);

        if(!isValid){
            return done(new UnauthorizedException(), false);
        }
        done(null, payload);
    }
}