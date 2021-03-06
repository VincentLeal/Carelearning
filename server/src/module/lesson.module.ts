import * as passport from 'passport';

import {MiddlewaresConsumer, Module, NestModule} from '@nestjs/common';
import {LessonService} from '../service/lesson.service';
import {Lesson} from '../entity/lesson';
import {TypeOrmModule} from '@nestjs/typeorm';
import {LessonController} from '../controller/lesson.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Lesson])],
    controllers: [LessonController],
    components: [LessonService],
})
export class LessonModule implements NestModule{
    public configure(consumer: MiddlewaresConsumer) {
        consumer
            .apply(passport.authenticate('jwt', { session: false }))
            .forRoutes(LessonController);
    }
}