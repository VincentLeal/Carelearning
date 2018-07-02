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
const jwt = require("jsonwebtoken");
const common_1 = require("@nestjs/common");
const student_service_1 = require("../service/student.service");
const encryptor_service_1 = require("./encryptor/encryptor.service");
let AuthService = class AuthService {
    constructor(studentService) {
        this.studentService = studentService;
    }
    createToken(student) {
        return __awaiter(this, void 0, void 0, function* () {
            const expireIn = 43800;
            const secretOrKey = 'secret';
            const token = jwt.sign(student, secretOrKey, { expireIn });
            return {
                expires_in: expireIn,
                access_token: token,
            };
        });
    }
    validateStudent(signedStudent) {
        return __awaiter(this, void 0, void 0, function* () {
            const { mail, password } = signedStudent;
            const student = yield this.studentService.findOneByMail(mail);
            return yield encryptor_service_1.EncryptorService.validate(password, student.password);
        });
    }
};
AuthService = __decorate([
    common_1.Component(),
    __metadata("design:paramtypes", [student_service_1.StudentService])
], AuthService);
exports.AuthService = AuthService;
//# sourceMappingURL=auth.service.js.map