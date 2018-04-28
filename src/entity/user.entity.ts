import {Column, Entity, ManyToMany, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Exercice} from "./exercice.entity";
import {Score} from "./score.entity";

@Entity()
export class User {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    firstname: string;

    @Column('text')
    lastname: string;

    @Column('text')
    password: string;

    @Column('text')
    mail: string;

    @Column('text')
    school: string;

    @Column('timestamp')
    register_date: string;

    @OneToMany(type => Score, score => score.user)
    score: Score[];
}