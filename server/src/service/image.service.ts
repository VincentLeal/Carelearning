import {Component} from '@nestjs/common/utils/decorators/component.decorator';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from 'typeorm';
import {Image} from '../entity/image.entity';

@Component()
export class ImageService {
    constructor(@InjectRepository(Image)
    private readonly imageRepository: Repository<Image>) {}

    async findAll(): Promise<Image[]> {
        return await this.imageRepository.find();
    }

    async findOne(id: number) {
        return await this.imageRepository.findOneById(id);
    }

    async create(image: Image) {
        return await this.imageRepository.save(image);
    }

    async createImages(images: Image[]) {
        return await this.imageRepository.save(images);
    }

    async update(id: number, imageData: Partial<Image>) {
        await this.imageRepository.updateById(id, imageData);
        return this.imageRepository.findOneById(id);
    }
    async destroy(id: number) {
        return await this.imageRepository.deleteById(id);
    }
}