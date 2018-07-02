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
const student_entity_1 = require("./student.entity");
const exercise_entity_1 = require("./exercise.entity");
let Result = class Result {
};
__decorate([
    typeorm_1.PrimaryGeneratedColumn(),
    __metadata("design:type", Number)
], Result.prototype, "id", void 0);
__decorate([
    typeorm_1.Column(),
    __metadata("design:type", String)
], Result.prototype, "date", void 0);
__decorate([
    typeorm_1.Column(),
    __metadata("design:type", Number)
], Result.prototype, "score", void 0);
__decorate([
    typeorm_1.ManyToOne(type => exercise_entity_1.Exercise),
    typeorm_1.JoinColumn({ name: 'exerciseId' }),
    __metadata("design:type", exercise_entity_1.Exercise)
], Result.prototype, "exercise", void 0);
__decorate([
    typeorm_1.ManyToOne(type => student_entity_1.Student),
    typeorm_1.JoinColumn({ name: 'studentId' }),
    __metadata("design:type", student_entity_1.Student)
], Result.prototype, "student", void 0);
Result = __decorate([
    typeorm_1.Entity()
], Result);
exports.Result = Result;
//# sourceMappingURL=result.entity.js.map