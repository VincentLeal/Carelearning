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
const revision_sheet_entity_1 = require("../entity/revision_sheet.entity");
const revision_sheet_service_1 = require("../service/revision_sheet.service");
let Revision_sheetController = class Revision_sheetController {
    constructor(revision_sheetService) {
        this.revision_sheetService = revision_sheetService;
    }
    findAll() {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetService.findAll();
        });
    }
    findOne(id) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetService.findOne(+id);
        });
    }
    create(revision_sheet) {
        return __awaiter(this, void 0, void 0, function* () {
            const createdRevision_sheet = yield this.revision_sheetService.create(revision_sheet);
            return { reivision_sheet: createdRevision_sheet };
        });
    }
    update(id, revision_sheet) {
        return __awaiter(this, void 0, void 0, function* () {
            return yield this.revision_sheetService.update(+id, revision_sheet);
        });
    }
    destroy(id) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.revision_sheetService.destroy(+id);
            return;
        });
    }
};
__decorate([
    common_1.Get(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], Revision_sheetController.prototype, "findAll", null);
__decorate([
    common_1.Get(':id'),
    __param(0, common_1.Param('id')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], Revision_sheetController.prototype, "findOne", null);
__decorate([
    common_1.Post(),
    __param(0, common_1.Body()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [revision_sheet_entity_1.Revision_sheet]),
    __metadata("design:returntype", Promise)
], Revision_sheetController.prototype, "create", null);
__decorate([
    common_1.Put(':id'),
    __param(0, common_1.Param('id')), __param(1, common_1.Body()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String, Object]),
    __metadata("design:returntype", Promise)
], Revision_sheetController.prototype, "update", null);
__decorate([
    common_1.Delete(':id'),
    __param(0, common_1.Param('id')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], Revision_sheetController.prototype, "destroy", null);
Revision_sheetController = __decorate([
    common_1.Controller('revision_sheet'),
    __metadata("design:paramtypes", [revision_sheet_service_1.Revision_sheetService])
], Revision_sheetController);
exports.Revision_sheetController = Revision_sheetController;
//# sourceMappingURL=revision_sheet.controller.js.map