import {Column, Entity, ManyToOne} from "typeorm";
import {User} from "./user.entity";
import {RevisionSheet} from "./revision_sheet.entity";

@Entity()
export class Revision_user {
    @Column()
    favorite: boolean;

    @ManyToOne(type => User, user => user.revision_user, { primary: true })
    user: User

    @ManyToOne(type => RevisionSheet, revision_sheet => revision_sheet.revision_user, { primary: true })
    revision_sheet: RevisionSheet
}