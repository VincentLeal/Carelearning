import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from "./result.entity";

@Entity()
export class Exercise {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    question: string;

    @Column({nullable: true})
    choice: string;

    @Column('text')
    module: string;

    @Column('text')
    type: string;

    @OneToMany(type => Result, result => result.exercise)
    results: Result[];
}
