import * as passport from 'passport';

import {Module, NestModule, MiddlewaresConsumer, RequestMethod} from '@nestjs/common';
import {ExerciseService} from '../service/exercise.service';
import {Exercise} from '../entity/exercise.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ExerciseController} from '../controller/exercise.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Exercise])],
    controllers: [ExerciseController],
    components: [ExerciseService],
})
export class ExerciseModule implements NestModule{
    public configure(consumer: MiddlewaresConsumer) {
        consumer
            .apply(passport.authenticate('jwt', { session: false }))
            .forRoutes({path: '/exercise', method: RequestMethod.ALL});
    }
}