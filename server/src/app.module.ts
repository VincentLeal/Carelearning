import { Module } from '@nestjs/common';
import {StudentModule} from './module/student.module';
import {ResultModule} from "./module/result.module";
import {ExerciseModule} from "./module/exercise.module";
import { TypeOrmModule } from "@nestjs/typeorm";
import {Revision_sheetModule} from "./module/revision_sheet.module";
import {LessonModule} from "./module/lesson.module";
import {AuthModule} from "./authentication/auth.module";
import {ImageModule} from './module/image.module';
import {PostStudentModule} from './module/postStudent.module';

@Module({
    imports: [
        StudentModule,
        PostStudentModule,
        ResultModule,
        ExerciseModule,
        Revision_sheetModule,
        LessonModule,
        ImageModule,
        AuthModule,
        TypeOrmModule.forRoot(),
    ],
})
export class ApplicationModule {}
