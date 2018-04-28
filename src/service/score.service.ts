import {Component} from '@nestjs/common';
import {Score} from '../entity/score.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from "typeorm";

@Component()
export class ScoreService {
    constructor(
        @InjectRepository(Score)
        private readonly scoreRepository: Repository<Score>
    ) {}

    async findAll(): Promise<Score[]> {
        return await this.scoreRepository.find();
    }

    async findOne(id: number): Promise<Score>{
        return await this.scoreRepository.findOneById(id);
    }

    async create(score: Score) {
        return await this.scoreRepository.save(score);
    }

    async update(id: number, scoreData: Partial<Score>): Promise<Score> {
        await this.scoreRepository.updateById(id, scoreData);
        return this.scoreRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.scoreRepository.deleteById(id);
    }
}