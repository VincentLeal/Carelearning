import {Column, Entity, JoinColumn, ManyToOne} from "typeorm";
import {User} from "./user.entity";
import {Lesson} from "./lesson";

@Entity()
export class Revision_sheet {
    @Column()
    favorite: boolean;

    @ManyToOne(type => User, { primary: true })
    @JoinColumn({name: 'userId'})
    user: User;

    @ManyToOne(type => Lesson, { primary: true })
    @JoinColumn({name: 'lessonId'})
    lesson: Lesson;
}