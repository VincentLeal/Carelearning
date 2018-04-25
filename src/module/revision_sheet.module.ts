import {Module} from '@nestjs/common';
import {RevisionSheetService} from '../service/revision_sheet.service';
import {RevisionSheet} from '../entity/revision_sheet.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {RevisionSheetController} from '../controller/revision_sheet.controller';

@Module({
    imports: [TypeOrmModule.forFeature([RevisionSheet])],
    controllers: [RevisionSheetController],
    components: [RevisionSheetService],
})
export class RevisionSheetModule {}