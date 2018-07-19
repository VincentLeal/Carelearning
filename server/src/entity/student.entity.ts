import {BeforeInsert, Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import {Result} from './result.entity';
import {Revision_sheet} from './revision_sheet.entity';
import {EncryptorService} from '../authentication/encryptor/encryptor.service';

@Entity()
export class Student {
    @PrimaryGeneratedColumn()
    id: number;

    @Column('text', { nullable: false })
    firstname: string;

    @Column('text', { nullable: false })
    lastname: string;

    @Column('text', { nullable: false })
    password: string;

    @Column('text', { nullable: false })
    mail: string;

    @Column('text', { nullable: false })
    school: string;

    @Column('timestamp')
    register_date: string;

    @Column('text', {default: 'user'})
    role: string;

    @BeforeInsert()
    async hashPassword(){
        this.password = await EncryptorService.encrypt(this.password);
    }

    @OneToMany(type => Result, result => result.student)
    results: Result[];

    @OneToMany(type => Revision_sheet, revision_sheet => revision_sheet.student)
    revision_sheets: Revision_sheet[];
}