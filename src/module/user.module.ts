import {Module} from '@nestjs/common';
import {UserService} from '../service/user.service';
import {User} from '../entity/user.entity';
import {TypeOrmModule} from '@nestjs/typeorm';
import {UserController} from '../controller/user.controller';

@Module({
    imports: [TypeOrmModule.forFeature([User])],
    controllers: [UserController],
    components: [UserService],
})
export class UserModule {}