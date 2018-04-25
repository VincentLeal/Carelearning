import {Column, Entity, PrimaryGeneratedColumn} from 'typeorm';

@Entity()
export class Exercice {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text')
    question: string;

    @Column({nullable: true})
    choice: string;

    @Column('text')
    module: string;

    @Column('text')
    type: string;

    @Column('boolean')
    isValidated: boolean;
}
