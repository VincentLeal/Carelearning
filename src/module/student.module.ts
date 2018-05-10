import {Module} from '@nestjs/common';
import {StudentService, UserService} from '../service/student.service';
import {Student, User} from '../entity/student.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {StudentController, UserController} from '../controller/student.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Student])],
    controllers: [StudentController],
    components: [StudentService],
})
export class StudentModule {}