import {Column, Entity, JoinColumn, ManyToOne, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {User} from "./user.entity";
import {Exercise} from "./exercise.entity";

@Entity()
export class Result {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    date: string;

    @Column()
    score: number;

    @ManyToOne(type => Exercise)
    @JoinColumn({name: 'exerciseId'})
    exercise: Exercise;

    @ManyToOne(type => User)
    @JoinColumn({name: 'userId'})
    user: User;
}