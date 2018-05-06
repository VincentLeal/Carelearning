import { Module } from '@nestjs/common';
import { UserModule } from './module/user.module';
import { ScoreModule } from "./module/score.module";
import { RevisionSheetModule } from "./module/revision_sheet.module";
import { ExerciceModule } from "./module/exercice.module";
import { TypeOrmModule } from "@nestjs/typeorm";
import {Historic_scoreModule} from "./module/historic_score.module";
import {Revision_userModule} from "./module/revision_user.module";

@Module({
  imports: [TypeOrmModule.forRoot(),
  UserModule,
  ScoreModule,
  Historic_scoreModule,
  ExerciceModule,
  RevisionSheetModule,
  Revision_userModule,
  ],
})
export class ApplicationModule {}
