import {Entity, JoinColumn, JoinTable, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {User} from "./user.entity";
import {Exercice} from "./exercice.entity";

@Entity()
export class Score{
    @PrimaryGeneratedColumn()

    @ManyToOne(type => User)
    @JoinColumn({name: 'userId'})
    user: User;

    @ManyToOne(type => Exercice)
    @JoinColumn({name: 'exerciceId'})
    exercice: Exercice



}