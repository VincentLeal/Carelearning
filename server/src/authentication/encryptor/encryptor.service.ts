import * as bcrypt from 'bcryptjs';

import { Component } from '@nestjs/common';

@Component()
export class EncryptorService {

    static async encrypt(password): Promise<string> {
        return await bcrypt.hash(password, 10);
    }

    static async validate(password, hash): Promise<boolean> {
        return await bcrypt.compare(password, hash);
    }
}