import { Module } from '@nestjs/common';
import {StudentModule} from './module/student.module';
import {ResultModule} from "./module/result.module";
import {ExerciseModule} from "./module/exercise.module";
import { TypeOrmModule } from "@nestjs/typeorm";
import {Revision_sheetModule} from "./module/revision_sheet.module";
import {LessonModule} from "./module/lesson.module";
import {AuthModule} from "./authentication/auth.module";

@Module({
    imports: [
        StudentModule,
        ResultModule,
        ExerciseModule,
        Revision_sheetModule,
        LessonModule,
        AuthModule,
        TypeOrmModule.forRoot(),
    ],
})
export class ApplicationModule {}
