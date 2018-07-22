import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from 'typeorm';
import {Exercise} from './exercise.entity';

@Entity()
export class Image {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text', {nullable: false})
    title: string;

    @Column('text', {nullable: false})
    label: string;

    @Column('text', { nullable: false})
    url: string;

    @ManyToOne(type => Exercise, exercise => exercise.images)
    @JoinColumn({name: 'exerciseId'})
    exercise: Exercise;
}