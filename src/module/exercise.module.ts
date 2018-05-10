import {Module} from '@nestjs/common';
import {ExerciseService} from '../service/exercise.service';
import {Exercise} from '../entity/exercise.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ExerciseController} from '../controller/exercise.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Exercise])],
    controllers: [ExerciseController],
    components: [ExerciseService],
})
export class ExerciseModule {}