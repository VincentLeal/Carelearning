import {Column, Entity, JoinColumn, JoinTable, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {User} from "./user.entity";
import {Exercice} from "./exercice.entity";

@Entity()
export class Score{
    @PrimaryGeneratedColumn()
    date: string;

    @Column()
    result: number;

    @ManyToOne(type => User)
    @JoinColumn({name: 'userId'})
    user: User;

    @ManyToOne(type => Exercice)
    @JoinColumn({name: 'exerciceId'})
    exercice: Exercice



}