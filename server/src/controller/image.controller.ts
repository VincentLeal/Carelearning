import {Body, Controller, Delete, Get, Param, Post, Put} from '@nestjs/common';
import {ImageService} from '../service/image.service';
import {Image} from '../entity/image.entity';
import {Exercise} from '../entity/exercise.entity';
import {ExerciseService} from '../service/exercise.service';

@Controller('image')
export class ImageController {
    constructor(private readonly imageService: ImageService) {}
    @Get()
    async findAll(): Promise<Image[]> {
        return await this.imageService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.imageService.findOne(+id);
    }

    @Post()
    async create(@Body() image: Image) {
        const createdImage = await this.imageService.create(image);
        return { image: createdImage };
    }

    @Post()
    async createImages(@Body() images: Image[]) {
        const createdImages = await this.imageService.createImages(images);

        return { images: createdImages };
    }

    @Put(':id')
    async update(@Param('id') id: string, @Body()image: Partial<Image>) {
        return await this.imageService.update(+id, image);
    }

    @Delete(':id')
    async destroy(@Param('id') id: string) {
        return await this.imageService.destroy(+id);
    }
}