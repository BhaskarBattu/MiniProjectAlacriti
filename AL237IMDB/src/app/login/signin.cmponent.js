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
var router_1 = require("@angular/router");
var signin_service_1 = require("./signin.service");
var utility_service_1 = require("../utility.service");
var SigninCmponent = (function () {
    function SigninCmponent(router, signinService, utilityService) {
        this.router = router;
        this.signinService = signinService;
        this.utilityService = utilityService;
        this.onSubmitted = new core_1.EventEmitter();
        this.onSubmittedRes = new core_1.EventEmitter();
        this.getUserRes = new core_1.EventEmitter(this.userResponse = true);
    }
    SigninCmponent.prototype.onSubmitLogin = function (userLogin) {
        var _this = this;
        this.signinService.login(userLogin).subscribe(function (response) {
            console.log(response);
            if (response.ok === true) {
                _this.userLoginResponse = response.json();
                if (_this.userLoginResponse === true) {
                    _this.router.navigate(['/dashboard']);
                }
                else {
                    alert('Invalid user name plese log in');
                    _this.router.navigate(['/Signin']);
                }
            }
        });
        /* let postData = {
             'email': email,
             'password': password,
         };*/
        /* console.log(userLogin);
         this.signinService.login(userLogin).subscribe((response) =>{
             console.log(response);
             if (response.ok === true) {
                     this.response = response.json();
                     // console.log(this.response);
                 this.userResponse = this.response.name;
                    // console.log(this.response.name);
                     this.getUserRes.emit(this.response.name);
                     this.onSubmitted.emit(true);
                     this.onSubmittedRes.emit(this.response.name);
                     this.utilityService.setUserInfo(this.response.name);
                         if (this.responseRegistration === true) {
                             this.router.navigate(['/dashboard']);
                         } else {
                             alert('username is already exists plese log in');
                             this.router.navigate(['/Signin']);
                         }
             } else {
                 alert('Please enter a valid username or password');
                 this.router.navigate(['/Signin']);
             }
         });*/
        /*this.httpService.postData(uname, password)
            .subscribe(resEmployeeData => this.postedData = JSON.stringify(resEmployeeData),
                resEmployeeError => alert( resEmployeeError),
                () => console.log('Finished'));*/
    };
    return SigninCmponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], SigninCmponent.prototype, "onSubmitted", void 0);
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], SigninCmponent.prototype, "onSubmittedRes", void 0);
SigninCmponent = __decorate([
    core_1.Component({
        selector: 'my-signin',
        templateUrl: './signin.component.html',
        styleUrls: ['./signin.component.css'],
        outputs: ['getUserRes']
    }),
    __metadata("design:paramtypes", [router_1.Router,
        signin_service_1.SigninService,
        utility_service_1.UtilityService])
], SigninCmponent);
exports.SigninCmponent = SigninCmponent;
//# sourceMappingURL=signin.cmponent.js.map