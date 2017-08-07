"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms"); // <-- NgModel lives here
var app_component_1 = require("./app.component");
var dashboard_component_1 = require("./dashboard/dashboard.component");
var search_component_1 = require("./searchmovie/search.component");
var registration_component_1 = require("./login/registration.component");
var signin_cmponent_1 = require("./login/signin.cmponent");
var app_routing_module_1 = require("./app-routing/app-routing.module");
var http_1 = require("@angular/http");
var hero_service_1 = require("./hero/hero.service");
var signin_service_1 = require("./login/signin.service");
var registration_service_1 = require("./login/registration.service");
var utility_service_1 = require("./utility.service");
var movie_service_1 = require("./dashboard/movies/movie.service");
var moviedescription_component_1 = require("./dashboard/movies/moviedescription/moviedescription.component");
var dashboard_service_1 = require("./dashboard/dashboard.service");
var movieDescrption_service_1 = require("./dashboard/movies/moviedescription/movieDescrption.service");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            app_routing_module_1.AppRoutingModule,
            http_1.HttpModule // <-- import the FormsModule before binding with [(ngModel)]
        ],
        declarations: [
            app_component_1.AppComponent,
            dashboard_component_1.DashboardComponent,
            search_component_1.SearchComponent,
            registration_component_1.RegistrationComponent,
            signin_cmponent_1.SigninCmponent,
            moviedescription_component_1.MoviedescriptionComponent
        ],
        providers: [hero_service_1.HeroService, movieDescrption_service_1.MovieDescrptionService, dashboard_service_1.DashboardService, signin_service_1.SigninService, registration_service_1.RegistrationService, utility_service_1.UtilityService, movie_service_1.MovieService],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map