import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {Student} from './student.entity';
import {Lesson} from './lesson';

@Entity()
export class Revision_sheet {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    favorite: boolean;

    @ManyToOne(type => Student)
    @JoinColumn({name: 'studentId'})
    student: Student;

    @ManyToOne(type => Lesson)
    @JoinColumn({name: 'lessonId'})
    lesson: Lesson;
}