import {Module} from '@nestjs/common';
import {ScoreService} from '../service/score.service';
import {Score} from '../entity/score.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ScoreController} from '../controller/score.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Score])],
    controllers: [ScoreController],
    components: [ScoreService],
})
export class ScoreModule {}