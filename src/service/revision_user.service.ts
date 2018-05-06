import {Component} from "@nestjs/common";
import {InjectRepository} from "@nestjs/typeorm";
import {Revision_user} from "../entity/revision_user.entity";
import {Repository} from "typeorm";

@Component()
export class Revision_userService {
    constructor(
        @InjectRepository(Revision_user)
        private readonly revision_userRepository: Repository<Revision_user>
    ) {}

    async findAll(): Promise<Revision_user[]> {
        return await this.revision_userRepository.find();
    }

    async findOne(id: number): Promise<Revision_user> {
        return await this.revision_userRepository.findOneById(id);
    }

    async create(revision_user: Revision_user) {
        return await this.revision_userRepository.save(revision_user);
    }

    async update(id: number, revision_userData: Partial<Revision_user>): Promise<Revision_user> {
        await this.revision_userRepository.updateById(id, revision_userData);
        return this.revision_userRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.revision_userRepository.deleteById(id);
    }
}