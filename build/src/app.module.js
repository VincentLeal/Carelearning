"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
const common_1 = require("@nestjs/common");
const student_module_1 = require("./module/student.module");
const result_module_1 = require("./module/result.module");
const exercise_module_1 = require("./module/exercise.module");
const typeorm_1 = require("@nestjs/typeorm");
const revision_sheet_module_1 = require("./module/revision_sheet.module");
const lesson_module_1 = require("./module/lesson.module");
const auth_module_1 = require("./authentication/auth.module");
let ApplicationModule = class ApplicationModule {
};
ApplicationModule = __decorate([
    common_1.Module({
        imports: [
            student_module_1.StudentModule,
            result_module_1.ResultModule,
            exercise_module_1.ExerciseModule,
            revision_sheet_module_1.Revision_sheetModule,
            lesson_module_1.LessonModule,
            auth_module_1.AuthModule,
            typeorm_1.TypeOrmModule.forRoot(),
        ],
    })
], ApplicationModule);
exports.ApplicationModule = ApplicationModule;
//# sourceMappingURL=app.module.js.map