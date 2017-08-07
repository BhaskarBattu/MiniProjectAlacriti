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
var hero_service_1 = require("../hero/hero.service");
var movie_service_1 = require("./movies/movie.service");
var router_1 = require("@angular/router");
var DashboardComponent = (function () {
    function DashboardComponent(heroService, router, movieService) {
        this.heroService = heroService;
        this.router = router;
        this.movieService = movieService;
        this.title = 'Tour of Dashboard';
        this.heroes = [];
    }
    DashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.observableMovies = this.movieService.getMoviesWithObservable();
        this.observableMovies.subscribe(function (moviesList) { return _this.moviesList = moviesList; }, function (error) { return _this.errorMessage = error; });
        /*this.heroService.getHeroes()
             .then(heroes => this.heroes = heroes.slice(1, 9));
         this.movieService.getMovies().then(movies => this.moviesList = movies.slice(0, 8));*/
    };
    DashboardComponent.prototype.onClickMovie = function (movieid, moviename, moviepath) {
        this.router.navigate(['/dashboard/MovieDescription/' + movieid, { id: movieid, moviename: moviename, movieImgPath: moviepath }]);
    };
    return DashboardComponent;
}());
DashboardComponent = __decorate([
    core_1.Component({
        selector: 'my-dashboard',
        templateUrl: './dashboard.component.html',
        styleUrls: ['./dashboard.component.css']
    }),
    __metadata("design:paramtypes", [hero_service_1.HeroService, router_1.Router, movie_service_1.MovieService])
], DashboardComponent);
exports.DashboardComponent = DashboardComponent;
//# sourceMappingURL=dashboard.component.js.map