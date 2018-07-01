import { Module } from '@nestjs/common';
import { AuthService } from "./auth.service";
import { JwtStrategy } from "./jwt.strategy";
import { StudentModule } from "../module/student.module";

@Module({
    imports: [StudentModule],
    providers: [AuthService, JwtStrategy],
})

export class AuthModule{}