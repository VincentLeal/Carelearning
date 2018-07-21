import {Component} from '@nestjs/common';
import {Result} from '../entity/result.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from 'typeorm';

@Component()
export class ResultService {
    constructor(
        @InjectRepository(Result)
        private readonly resultRepository: Repository<Result>,
    ) {}

    async findAll(): Promise<Result[]> {
        return await this.resultRepository.find();
    }

    async findOne(id: number): Promise<Result>{
        return await this.resultRepository.findOneById(id);
    }

    async create(result: Result) {
        return await this.resultRepository.save(result);
    }
}