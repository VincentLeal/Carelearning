import {Body, Controller, Delete, Get, Param, Post, Put, Req} from '@nestjs/common';
import {ImageService} from '../service/image.service';
import {Image} from '../entity/image.entity';
import {RoleVerificator} from '../authentication/role.verificator';

@Controller('image')
export class ImageController {
    private readonly roleVerificator: RoleVerificator;

    constructor(private readonly imageService: ImageService) {
        this.roleVerificator = new RoleVerificator('admin');
    }

    @Get()
    async findAll(): Promise<Image[]> {
        return await this.imageService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string) {
        return await this.imageService.findOne(+id);
    }

    @Post()
    async create(@Req() request, @Body() image: Image) {
        this.roleVerificator.verify(request.user);
        const createdImage = await this.imageService.save(image);
        return { image: createdImage };
    }

    @Post()
    async createImages(@Req() request, @Body() images: Image[]) {
        this.roleVerificator.verify(request.user);
        const createdImages = await this.imageService.saveImages(images);
        return { images: createdImages };
    }

    @Put(':id')
    async update(@Req() request, @Param('id') id: string, @Body()image: Partial<Image>) {
        this.roleVerificator.verify(request.user);
        return await this.imageService.update(+id, image);
    }

    @Delete(':id')
    async destroy(@Req() request, @Param('id') id: string) {
        this.roleVerificator.verify(request.user);
        return await this.imageService.destroy(+id);
    }
}