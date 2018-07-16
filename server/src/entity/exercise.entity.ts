import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from './result.entity';
import {Image} from './image.entity';

@Entity()
export class Exercise {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    question: string;

    @Column({nullable: true})
    goodAnswer: string;

    @Column({nullable: true})
    choice1: string;

    @Column({nullable: true})
    choice2: string;

    @Column({nullable: true})
    choice3: string;

    @Column('text')
    module: string;

    @Column('text')
    type: string;

    @OneToMany(type => Result, result => result.exercise)
    results: Result[];

    @OneToMany(type => Image, image => image.exercise)
    images: Image[];
}
