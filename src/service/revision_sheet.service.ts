import {Component} from '@nestjs/common';
import {RevisionSheet} from '../entity/revision_sheet.entity';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from "typeorm";

@Component()
export class RevisionSheetService {
    constructor(
        @InjectRepository(RevisionSheet)
        private readonly revisionSheetRepository: Repository<RevisionSheet>
    ) {}

    async findAll(): Promise<RevisionSheet[]> {
        return await this.revisionSheetRepository.find();
    }

    async findOne(id: number) {
        return await this.revisionSheetRepository.findOneById(id);
    }
    async create(revisionSheet: RevisionSheet) {
        return await this.revisionSheetRepository.save(revisionSheet);
    }
    async update(id: number, revisionSheetData: Partial<RevisionSheet>) {
        await this.revisionSheetRepository.updateById(id, revisionSheetData);
        return this.revisionSheetRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.revisionSheetRepository.deleteById(id);
    }
}