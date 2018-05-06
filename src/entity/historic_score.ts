import {Column, Entity, JoinColumn, ManyToOne, OneToMany, PrimaryGeneratedColumn} from "typeorm";
import {Score} from "./score.entity";
import {User} from "./user.entity";
import {Exercice} from "./exercice.entity";

@Entity()
export class Historic_score {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    date: string;

    @ManyToOne(type => Score)
    @JoinColumn([{name: 'userId', referencedColumnName: 'id'},
        {name: 'exerciceId', referencedColumnName: 'id'},
        {name: 'scoreDateId', referencedColumnName: 'id'}])
    user: User;
    exercice: Exercice;
    score: Score
}