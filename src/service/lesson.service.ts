import {Component} from '@nestjs/common';
import {Lesson} from '../entity/lesson';
import {InjectRepository} from '@nestjs/typeorm';
import {Repository} from "typeorm";

@Component()
export class LessonService {
    constructor(
        @InjectRepository(Lesson)
        private readonly lessonRepository: Repository<Lesson>
    ) {}

    async findAll(): Promise<Lesson[]> {
        return await this.lessonRepository.find();
    }

    async findOne(id: number) {
        return await this.lessonRepository.findOneById(id);
    }
    async create(lesson: Lesson) {
        return await this.lessonRepository.save(lesson);
    }
    async update(id: number, lessonData: Partial<Lesson>) {
        await this.lessonRepository.updateById(id, lessonData);
        return this.lessonRepository.findOneById(id);
    }

    async destroy(id: number) {
        return await this.lessonRepository.deleteById(id);
    }
}