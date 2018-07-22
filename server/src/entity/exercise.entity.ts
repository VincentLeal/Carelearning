import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from './result.entity';
import {Image} from './image.entity';

@Entity()
export class Exercise {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    question: string;

    @Column({nullable: false})
    goodAnswer: string;

    @Column({nullable: false})
    choice1: string;

    @Column({nullable: false})
    choice2: string;

    @Column({nullable: false})
    choice3: string;

    @Column('text', { nullable: false})
    module: string;

    @Column('text', { nullable: false})
    type: string;

    @OneToMany(type => Result, result => result.exercise)
    results: Result[];

    @OneToMany(type => Image, image => image.exercise)
    images: Image[];
}
