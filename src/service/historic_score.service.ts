import {Component} from "@nestjs/common";
import {InjectRepository} from "@nestjs/typeorm";
import {Historic_score} from "../entity/historic_score";
import {Repository} from "typeorm";

@Component()
export class Historic_scoreService {
    constructor(
        @InjectRepository(Historic_score)
        private readonly historic_scoreRepository: Repository<Historic_score>
    ) {}

    async findAll(): Promise<Historic_score[]> {
        return await this.historic_scoreRepository.find();
    }

    async findOne(id: number): Promise<Historic_score> {
        return await this.historic_scoreRepository.findOneById(id);
    }

    async create(historic_score: Historic_score) {
        return await this.historic_scoreRepository.save(historic_score);
    }

    async update(id: number, historic_scoreData: Partial<Historic_score>): Promise<Historic_score> {
       await this.historic_scoreRepository.updateById(id, historic_scoreData);
       return this.historic_scoreRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.historic_scoreRepository.deleteById(id);
    }

}