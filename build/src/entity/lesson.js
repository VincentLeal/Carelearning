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
Object.defineProperty(exports, "__esModule", { value: true });
const typeorm_1 = require("typeorm");
const revision_sheet_entity_1 = require("./revision_sheet.entity");
let Lesson = class Lesson {
};
__decorate([
    typeorm_1.PrimaryGeneratedColumn(),
    __metadata("design:type", Number)
], Lesson.prototype, "id", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Lesson.prototype, "module", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Lesson.prototype, "title", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Lesson.prototype, "content", void 0);
__decorate([
    typeorm_1.OneToMany(type => revision_sheet_entity_1.Revision_sheet, revision_sheet => revision_sheet.lesson),
    __metadata("design:type", revision_sheet_entity_1.Revision_sheet)
], Lesson.prototype, "revision_sheet", void 0);
Lesson = __decorate([
    typeorm_1.Entity()
], Lesson);
exports.Lesson = Lesson;
//# sourceMappingURL=lesson.js.map