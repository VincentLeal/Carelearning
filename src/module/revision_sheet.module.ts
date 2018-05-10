import {Module} from "@nestjs/common";
import {TypeOrmModule} from "@nestjs/typeorm";
import {Revision_sheet} from "../entity/revision_sheet.entity";
import {Revision_sheetController} from "../controller/revision_sheet.controller";
import {Revision_sheetService} from "../service/revision_sheet.service";

@Module({
    imports: [TypeOrmModule.forFeature([Revision_sheet])],
    controllers: [Revision_sheetController],
    components: [Revision_sheetService],
})
export class Revision_sheetModule {}