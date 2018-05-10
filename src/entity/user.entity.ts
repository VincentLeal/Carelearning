import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from "./result.entity";
import {Revision_sheet} from "./revision_sheet.entity";

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

    @OneToMany(type => Result, result => result.user)
    result: Result[];

    @OneToMany(type => Revision_sheet, revision_sheet => revision_sheet.user)
    revision_sheet: Revision_sheet[];
}