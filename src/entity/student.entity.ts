import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from "./result.entity";
import {Revision_sheet} from "./revision_sheet.entity";

@Entity()
export class Student {
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

    @OneToMany(type => Result, result => result.student)
    results: Result[];

    @OneToMany(type => Revision_sheet, revision_sheet => revision_sheet.student)
    revision_sheets: Revision_sheet[];
}