import {Column, Entity, JoinColumn, JoinTable, ManyToOne, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {User} from "./user.entity";
import {Exercice} from "./exercice.entity";
import {Historic_score} from "./historic_score";

@Entity()
export class Score{
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    date: string;

    @Column()
    result: number;

    @ManyToOne(type => User, { primary: true })
    @JoinColumn({name: 'userId'})
    user: User;

    @ManyToOne(type => Exercice, { primary: true })
    @JoinColumn({name: 'exerciceId'})
    exercice: Exercice

    @OneToMany(type => Historic_score, historic_score => historic_score.score)
    historic_score: Historic_score[];


}