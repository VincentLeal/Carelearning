import {Component} from '@nestjs/common';
import {Repository} from 'typeorm';
import {User} from '../entity/user.entity';
import {InjectRepository} from '@nestjs/typeorm';

@Component()
export class UserService {
    constructor(
        @InjectRepository(User)
        private readonly userRepository: Repository<User>
    ) {}

    async findAll(): Promise<User[]> {
        return await this.userRepository.find();
    }

    async findOne(id: number): Promise<User>{
        return await this.userRepository.findOneById(id);
    }

    async create(user: User) {
        return await this.userRepository.save(user);
    }

    async update(id: number, userData: Partial<User>): Promise<User> {
        await this.userRepository.updateById(id, userData);
        return this.userRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.userRepository.deleteById(id);
    }
}