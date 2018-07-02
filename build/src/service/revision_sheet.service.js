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
const typeorm_1 = require("@nestjs/typeorm");
const revision_sheet_entity_1 = require("../entity/revision_sheet.entity");
const typeorm_2 = require("typeorm");
let Revision_sheetService = class Revision_sheetService {
    constructor(revision_sheetRepository) {
        this.revision_sheetRepository = revision_sheetRepository;
    }
    findAll() {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetRepository.find();
        });
    }
    findOne(id) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetRepository.findOneById(id);
        });
    }
    create(revision_sheet) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetRepository.save(revision_sheet);
        });
    }
    update(id, revision_sheetData) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.revision_sheetRepository.updateById(id, revision_sheetData);
            return this.revision_sheetRepository.findOneById(id);
        });
    }
    destroy(id) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetRepository.deleteById(id);
        });
    }
};
Revision_sheetService = __decorate([
    common_1.Component(),
    __param(0, typeorm_1.InjectRepository(revision_sheet_entity_1.Revision_sheet)),
    __metadata("design:paramtypes", [typeorm_2.Repository])
], Revision_sheetService);
exports.Revision_sheetService = Revision_sheetService;
//# sourceMappingURL=revision_sheet.service.js.map