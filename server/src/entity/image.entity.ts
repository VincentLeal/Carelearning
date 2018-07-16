import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {Exercise} from './exercise.entity';

@Entity()
export class Image {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    title: string;

    @Column('text')
    label: string;

    @Column('text')
    url: string;

    @ManyToOne(type => Exercise)
    @JoinColumn({name: 'exerciseId'})
    exercise: Exercise;
}