import {Component} from '@nestjs/common';
import {Repository} from 'typeorm';
import {Exercice} from '../entity/exercice.entity';
import {InjectRepository} from '@nestjs/typeorm';

@Component()
export class ExerciceService {
    constructor(
        @InjectRepository(Exercice)
        private readonly exerciceRepository: Repository<Exercice>
    ) {}

    async findAll(): Promise<Exercice[]> {
        return await this.exerciceRepository.find();
    }

    async findOne(id: number): Promise<Exercice>{
        return await this.exerciceRepository.findOneById(id);
    }

    async create(exercice: Exercice) {
        return await this.exerciceRepository.save(exercice);
    }

    async update(id: number, exerciceData: Partial<Exercice>): Promise<Exercice> {
        await this.exerciceRepository.updateById(id, exerciceData);
        return this.exerciceRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.exerciceRepository.deleteById(id);
    }
}