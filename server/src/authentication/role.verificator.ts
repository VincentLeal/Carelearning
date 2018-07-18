import {HttpException, HttpStatus} from '@nestjs/common';

export class RoleVerificator {
    private readonly authorizedRoles: string[];

    constructor(...authorizedRoles: string[]) {
        this.authorizedRoles = authorizedRoles;
    }

    verify(user): boolean {
        if(!user || !this.hasSufficientRole(this.authorizedRoles, user.role)){
            throw new HttpException('Forbidden', HttpStatus.FORBIDDEN);
        }
    }

    private hasSufficientRole(roles: any[], currentUserRole) {
        return roles.find(value => currentUserRole === value);
    }
}