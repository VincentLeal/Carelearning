import {Component} from '@nestjs/common';
import {Exercise} from '../entity/exercise.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from "typeorm";

@Component()
export class ExerciseService {
    constructor(
        @InjectRepository(Exercise)
        private readonly exerciseRepository: Repository<Exercise>
    ) {}

    async findAll(): Promise<Exercise[]> {
        return await this.exerciseRepository.find();
    }

    async findOne(id: number): Promise<Exercise>{
        return await this.exerciseRepository.findOneById(id);
    }

    async create(exercise: Exercise) {
        return await this.exerciseRepository.save(exercise);
    }

    async update(id: number, exerciseData: Partial<Exercise>): Promise<Exercise> {
        await this.exerciseRepository.updateById(id, exerciseData);
        return this.exerciseRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.exerciseRepository.deleteById(id);
    }
}