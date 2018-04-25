import {Column, Entity, PrimaryGeneratedColumn} from 'typeorm';

@Entity()
export class RevisionSheet{
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    module: string;

    @Column('text')
    title: string;

    @Column('text')
    content: string;

    @Column('boolean')
    isDone: boolean;
}