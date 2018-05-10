import { Module } from '@nestjs/common';
import { UserModule } from './module/user.module';
import {ResultModule} from "./module/result.module";
import {ExerciseModule} from "./module/exercise.module";
import { TypeOrmModule } from "@nestjs/typeorm";
import {Revision_sheetModule} from "./module/revision_sheet.module";
import {LessonModule} from "./module/lesson.module";

@Module({
  imports: [TypeOrmModule.forRoot(),
  UserModule,
  ResultModule,
  ExerciseModule,
  Revision_sheetModule,
  LessonModule,
  ],
})
export class ApplicationModule {}
