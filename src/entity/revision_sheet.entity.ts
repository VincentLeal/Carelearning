import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Revision_user} from "./revision_user.entity";

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

    @OneToMany(type => Revision_user, revision_user => revision_user.revision_sheet)
    revision_user: Revision_user;
}