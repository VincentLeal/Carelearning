"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const lesson_service_1 = require("../service/lesson.service");
const lesson_1 = require("../entity/lesson");
const typeorm_1 = require("@nestjs/typeorm");
const lesson_controller_1 = require("../controller/lesson.controller");
let LessonModule = class LessonModule {
};
LessonModule = __decorate([
    common_1.Module({
        imports: [typeorm_1.TypeOrmModule.forFeature([lesson_1.Lesson])],
        controllers: [lesson_controller_1.LessonController],
        components: [lesson_service_1.LessonService],
    })
], LessonModule);
exports.LessonModule = LessonModule;
//# sourceMappingURL=lesson.module.js.map