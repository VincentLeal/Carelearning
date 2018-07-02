import { Module } from '@nestjs/common';
import { AuthService } from "./auth.service";
import { JwtStrategy } from "./jwt/jwt.strategy";
import { StudentModule } from "../module/student.module";
import {AuthController} from "./auth.controller";

@Module({
    controllers: [AuthController],
    components: [AuthService, JwtStrategy],
    imports: [StudentModule],
    exports: [AuthService, JwtStrategy],
})

export class AuthModule{}