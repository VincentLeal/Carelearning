import { Module } from '@nestjs/common';
import { AuthService } from './auth.service';
import { JwtStrategy } from './jwt/jwt.strategy';
import { StudentModule } from '../module/student.module';
import {TypeOrmModule} from '@nestjs/typeorm';

import {AuthController} from './auth.controller';
import {Student} from '../entity/student.entity';

@Module({
    controllers: [AuthController],
    components: [AuthService, JwtStrategy],
    imports: [StudentModule, TypeOrmModule.forFeature([Student])],
})

export class AuthModule{}