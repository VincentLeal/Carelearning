import * as passport from 'passport';

import {MiddlewaresConsumer, Module, NestModule} from '@nestjs/common';
import {TypeOrmModule} from '@nestjs/typeorm';
import {ImageService} from '../service/image.service';
import {Image} from '../entity/image.entity';
import {ImageController} from '../controller/image.controller';

@Module({
    imports: [TypeOrmModule.forFeature([Image])],
    controllers: [ImageController],
    components: [ImageService],
    exports: [ImageService],
})
export class ImageModule implements NestModule {
    public configure(consumer: MiddlewaresConsumer) {
        consumer
            .apply(passport.authenticate('jwt', {session: false}))
            .forRoutes(ImageController);
    }
}
