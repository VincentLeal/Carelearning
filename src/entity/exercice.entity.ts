import {Column, Entity, JoinColumn, ManyToOne, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Score} from "./score.entity";

@Entity()
export class Exercice {
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

    @Column('boolean')
    isValidated: boolean;

    @OneToMany(type => Score, score => score.exercice)
    scores: Score[];
}
