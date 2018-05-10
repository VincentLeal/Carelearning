import {Module} from '@nestjs/common';
import {LessonService} from '../service/lesson.service';
import {Lesson} from '../entity/lesson';
import {TypeOrmModule} from '@nestjs/typeorm';
import {LessonController} from '../controller/lesson.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Lesson])],
    controllers: [LessonController],
    components: [LessonService],
})
export class LessonModule {}