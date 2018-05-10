import {Component} from "@nestjs/common";
import {InjectRepository} from "@nestjs/typeorm";
import {Revision_sheet} from "../entity/revision_sheet.entity";
import {Repository} from "typeorm";

@Component()
export class Revision_sheetService {
    constructor(
        @InjectRepository(Revision_sheet)
        private readonly revision_sheetRepository: Repository<Revision_sheet>
    ) {}

    async findAll(): Promise<Revision_sheet[]> {
        return await this.revision_sheetRepository.find();
    }

    async findOne(id: number): Promise<Revision_sheet> {
        return await this.revision_sheetRepository.findOneById(id);
    }

    async create(revision_sheet: Revision_sheet) {
        return await this.revision_sheetRepository.save(revision_sheet);
    }

    async update(id: number, revision_sheetData: Partial<Revision_sheet>): Promise<Revision_user> {
        await this.revision_sheetRepository.updateById(id, revision_sheetData);
        return this.revision_sheetRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.revision_sheetRepository.deleteById(id);
    }
}