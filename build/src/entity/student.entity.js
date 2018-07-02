"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const typeorm_1 = require("typeorm");
const result_entity_1 = require("./result.entity");
const revision_sheet_entity_1 = require("./revision_sheet.entity");
const encryptor_service_1 = require("../authentication/encryptor/encryptor.service");
let Student = class Student {
    hashPassword() {
        return __awaiter(this, void 0, void 0, function* () {
            this.password = yield encryptor_service_1.EncryptorService.encrypt(this.password);
        });
    }
};
__decorate([
    typeorm_1.PrimaryGeneratedColumn(),
    __metadata("design:type", Number)
], Student.prototype, "id", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Student.prototype, "firstname", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Student.prototype, "lastname", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Student.prototype, "password", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Student.prototype, "mail", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Student.prototype, "school", void 0);
__decorate([
    typeorm_1.Column('timestamp'),
    __metadata("design:type", String)
], Student.prototype, "register_date", void 0);
__decorate([
    typeorm_1.BeforeInsert(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], Student.prototype, "hashPassword", null);
__decorate([
    typeorm_1.OneToMany(type => result_entity_1.Result, result => result.student),
    __metadata("design:type", Array)
], Student.prototype, "results", void 0);
__decorate([
    typeorm_1.OneToMany(type => revision_sheet_entity_1.Revision_sheet, revision_sheet => revision_sheet.student),
    __metadata("design:type", Array)
], Student.prototype, "revision_sheets", void 0);
Student = __decorate([
    typeorm_1.Entity()
], Student);
exports.Student = Student;
//# sourceMappingURL=student.entity.js.map