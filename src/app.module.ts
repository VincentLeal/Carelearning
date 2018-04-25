import { Module } from '@nestjs/common';
import { UserModule } from './module/user.module';
import { ScoreModule } from "./module/score.module";
import { RevisionSheetModule } from "./module/revision_sheet.module";
import { ExerciceModule } from "./module/exercice.module";
import { TypeOrmModule } from "@nestjs/typeorm";

@Module({
  imports: [TypeOrmModule.forRoot(),
  UserModule,
  ScoreModule,
  ExerciceModule,
  RevisionSheetModule,
  ],
})
export class ApplicationModule {}
