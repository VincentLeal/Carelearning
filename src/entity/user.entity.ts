import {Column, Entity, PrimaryGeneratedColumn} from 'typeorm';

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
}