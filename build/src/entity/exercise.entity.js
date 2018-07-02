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
const result_entity_1 = require("./result.entity");
let Exercise = class Exercise {
};
__decorate([
    typeorm_1.PrimaryGeneratedColumn(),
    __metadata("design:type", Number)
], Exercise.prototype, "id", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Exercise.prototype, "question", void 0);
__decorate([
    typeorm_1.Column({ nullable: true }),
    __metadata("design:type", String)
], Exercise.prototype, "choice", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Exercise.prototype, "module", void 0);
__decorate([
    typeorm_1.Column('text'),
    __metadata("design:type", String)
], Exercise.prototype, "type", void 0);
__decorate([
    typeorm_1.OneToMany(type => result_entity_1.Result, result => result.exercise),
    __metadata("design:type", Array)
], Exercise.prototype, "results", void 0);
Exercise = __decorate([
    typeorm_1.Entity()
], Exercise);
exports.Exercise = Exercise;
//# sourceMappingURL=exercise.entity.js.map