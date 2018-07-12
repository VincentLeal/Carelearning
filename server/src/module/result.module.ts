import {Module} from '@nestjs/common';
import {TypeOrmModule} from '@nestjs/typeorm';
import {Result} from "../entity/result.entity";
import {ResultController} from "../controller/result.controller";
import {ResultService} from "../service/result.service";

@Module({
    imports: [TypeOrmModule.forFeature([Result])],
    controllers: [ResultController],
    components: [ResultService],
})
export class ResultModule {}