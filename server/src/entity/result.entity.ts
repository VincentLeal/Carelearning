import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {Student} from "./student.entity";
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

    @ManyToOne(type => Student)
    @JoinColumn({name: 'studentId'})
    student: Student;
}