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
var core_1 = require("@angular/core");
var registration_service_1 = require("./registration.service");
var router_1 = require("@angular/router");
var RegistrationComponent = (function () {
    function RegistrationComponent(regService, router) {
        this.regService = regService;
        this.router = router;
    }
    RegistrationComponent.prototype.onSubmit = function (userReg) {
        var _this = this;
        console.log(userReg);
        this.regService.registration(userReg).subscribe(function (response) {
            //console.log(response);
            if (response.ok === true) {
                // if (response.status === 200) {
                _this.responseRegistration = response.json();
                console.log(_this.responseRegistration);
                if (_this.responseRegistration === true) {
                    _this.router.navigate(['/dashboard']);
                }
                else {
                    alert('username is already exists plese log in');
                    _this.router.navigate(['/Signin']);
                }
            }
        });
    };
    return RegistrationComponent;
}());
RegistrationComponent = __decorate([
    core_1.Component({
        selector: 'my-registration',
        templateUrl: './registration.component.html',
        styleUrls: ['./registration.component.css']
    }),
    __metadata("design:paramtypes", [registration_service_1.RegistrationService, router_1.Router])
], RegistrationComponent);
exports.RegistrationComponent = RegistrationComponent;
//# sourceMappingURL=registration.component.js.map