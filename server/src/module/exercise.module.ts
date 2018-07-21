import * as passport from 'passport';

import {MiddlewaresConsumer, Module, NestModule} from '@nestjs/common';
import {ExerciseService} from '../service/exercise.service';
import {Exercise} from '../entity/exercise.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ExerciseController} from '../controller/exercise.controller';
import {ImageService} from '../service/image.service';
import {Image} from '../entity/image.entity';

@Module({
    imports: [TypeOrmModule.forFeature([Exercise, Image])],
    controllers: [ExerciseController],
    components: [ExerciseService, ImageService],
})
export class ExerciseModule implements NestModule{
    public configure(consumer: MiddlewaresConsumer) {
        consumer
            .apply(passport.authenticate('jwt', { session: false }))
            .forRoutes(ExerciseController);
    }
}