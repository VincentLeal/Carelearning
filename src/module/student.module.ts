import {Module} from '@nestjs/common';
import {StudentService } from '../service/student.service';
import {Student} from '../entity/student.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {StudentController} from '../controller/student.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Student])],
    controllers: [StudentController],
    components: [StudentService],
})
export class StudentModule {}