import {Module} from '@nestjs/common';
import {ExerciceService} from '../service/exercice.service';
import {Exercice} from '../entity/exercice.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ExerciceController} from '../controller/exercice.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Exercice])],
    controllers: [ExerciceController],
    components: [ExerciceService],
})
export class ExerciceModule {}