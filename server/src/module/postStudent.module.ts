import {Module} from '@nestjs/common';
import {TypeOrmModule} from '@nestjs/typeorm';
import {Student} from '../entity/student.entity';
import {StudentService} from '../service/student.service';
import {PostStudentController} from '../controller/postStudent.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Student])],
    controllers: [PostStudentController],
    components: [StudentService],
    exports: [StudentService],
})

export class PostStudentModule {}