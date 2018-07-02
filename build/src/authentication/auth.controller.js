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
const auth_service_1 = require("./auth.service");
const student_service_1 = require("../service/student.service");
const student_entity_1 = require("../entity/student.entity");
const encryptor_service_1 = require("./encryptor/encryptor.service");
let AuthController = class AuthController {
    constructor(authService, studentService) {
        this.authService = authService;
        this.studentService = studentService;
    }
    getToken(credentials) {
        return __awaiter(this, void 0, void 0, function* () {
            const { mail, password } = credentials;
            const student = yield this.studentService.findOneByMail(mail);
            if (student) {
                const result = yield encryptor_service_1.EncryptorService.validate(password, student.password);
                if (result) {
                    return yield this.authService.createToken(credentials);
                }
            }
            throw new common_1.BadRequestException("Invalid credentials");
        });
    }
};
__decorate([
    common_1.Post(),
    __param(0, common_1.Body()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [student_entity_1.Student]),
    __metadata("design:returntype", Promise)
], AuthController.prototype, "getToken", null);
AuthController = __decorate([
    common_1.Controller('auth'),
    __metadata("design:paramtypes", [auth_service_1.AuthService,
        student_service_1.StudentService])
], AuthController);
exports.AuthController = AuthController;
//# sourceMappingURL=auth.controller.js.map