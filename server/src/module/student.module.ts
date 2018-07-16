import * as passport from 'passport';

import {MiddlewaresConsumer, Module, NestModule, RequestMethod} from '@nestjs/common';
import {StudentService } from '../service/student.service';
import {Student} from '../entity/student.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {StudentController} from '../controller/student.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Student])],
    controllers: [StudentController],
    components: [StudentService],
    exports: [StudentService],
})
export class StudentModule implements NestModule {
    public configure(consumer: MiddlewaresConsumer) {
        consumer
            .apply(passport.authenticate('jwt', {session: false}))
            .forRoutes({path: '/student', method: RequestMethod.ALL});
    }
}