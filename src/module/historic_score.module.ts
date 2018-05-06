import {Module} from "@nestjs/common";
import {TypeOrmModule} from "@nestjs/typeorm";
import {Historic_score} from "../entity/historic_score";
import {Historic_scoreController} from "../controller/historic_score.controller";
import {Historic_scoreService} from "../service/historic_score.service";

@Module({
    imports: [TypeOrmModule.forFeature([Historic_score])],
    controllers: [Historic_scoreController],
    components: [Historic_scoreService],
})
export class Historic_scoreModule {}