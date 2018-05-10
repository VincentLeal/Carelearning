import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Revision_sheet} from "./revision_sheet.entity";

@Entity()
export class Lesson {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    module: string;

    @Column('text')
    title: string;

    @Column('text')
    content: string;

    @OneToMany(type => Revision_sheet, revision_sheet => revision_sheet.lesson)
    revision_sheet: Revision_sheet;
}