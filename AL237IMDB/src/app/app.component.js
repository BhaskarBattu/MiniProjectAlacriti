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
var utility_service_1 = require("./utility.service");
var AppComponent = (function () {
    // public userInfo = this.utilityService.userInfo;
    function AppComponent(utilityService) {
        this.utilityService = utilityService;
        this.title = 'Tour of Heroes';
        this.user = '';
        this.isUserLoggedIn = false;
    }
    AppComponent.prototype.getUserName = function () {
        // console.log( this.utilityService.getUserInfo());
        this.utilityService.getUserInfo();
    };
    AppComponent.prototype.ngOnInit = function () {
        // console.log('App Component');
        this.getUserName();
        /*this.utilityService.getUserInfo().then(userInfo => {
          this.isUserLoggedIn = true;
            this.userInfo = userInfo;
        }).catch(() => {
          console.log('Rejected userInfo from utility clsses');
        });*/
    };
    AppComponent.prototype.onSubmitted = function (loggenIn) {
        // console.log('bhasi');
        this.isUserLoggedIn = true;
    };
    AppComponent.prototype.onSubmittedRes = function (logRes) {
        this.useRegname = logRes;
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.css']
    }),
    __metadata("design:paramtypes", [utility_service_1.UtilityService])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map