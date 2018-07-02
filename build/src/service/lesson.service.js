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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
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
const common_1 = require("@nestjs/common");
const lesson_1 = require("../entity/lesson");
const typeorm_1 = require("@nestjs/typeorm");
const typeorm_2 = require("typeorm");
let LessonService = class LessonService {
    constructor(lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    findAll() {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.lessonRepository.find();
        });
    }
    findOne(id) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.lessonRepository.findOneById(id);
        });
    }
    create(lesson) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.lessonRepository.save(lesson);
        });
    }
    update(id, lessonData) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.lessonRepository.updateById(id, lessonData);
            return this.lessonRepository.findOneById(id);
        });
    }
    destroy(id) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.lessonRepository.deleteById(id);
        });
    }
};
LessonService = __decorate([
    common_1.Component(),
    __param(0, typeorm_1.InjectRepository(lesson_1.Lesson)),
    __metadata("design:paramtypes", [typeorm_2.Repository])
], LessonService);
exports.LessonService = LessonService;
//# sourceMappingURL=lesson.service.js.map