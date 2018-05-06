import {Module} from "@nestjs/common";
import {TypeOrmModule} from "@nestjs/typeorm";
import {Revision_user} from "../entity/revision_user.entity";
import {Revision_userController} from "../controller/revision_user.controller";
import {Revision_userService} from "../service/revision_user.service";

@Module({
    imports: [TypeOrmModule.forFeature([Revision_user])],
    controllers: [Revision_userController],
    components: [Revision_userService],
})
export class Revision_userModule {}