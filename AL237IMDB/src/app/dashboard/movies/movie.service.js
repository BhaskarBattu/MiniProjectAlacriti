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
var movie_names_1 = require("./movie-names");
var http_1 = require("@angular/http");
var Observable_1 = require("rxjs/Observable");
var MovieService = (function () {
    function MovieService(http) {
        this.http = http;
        this.Url = 'api/dashboard/MovieDescription';
        this.movieUrl = 'http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/movieDetails';
    }
    MovieService.prototype.getMoviesWithObservable = function () {
        return this.http.get(this.movieUrl)
            .map(this.extractMovieData)
            .catch(this.handleErrorObservable);
    };
    MovieService.prototype.extractMovieData = function (res) {
        var body = res.json();
        return body;
    };
    MovieService.prototype.handleErrorObservable = function (error) {
        console.error(error.message || error);
        return Observable_1.Observable.throw(error.message || error);
    };
    MovieService.prototype.getMovies = function () {
        return Promise.resolve(movie_names_1.MovieNames);
    };
    MovieService.prototype.getMoviesSlowly = function () {
        var _this = this;
        return new Promise(function (resolve) {
            // Simulate server latency with 2 second delay
            setTimeout(function () { return resolve(_this.getMovies()); }, 2000);
        });
    };
    return MovieService;
}());
MovieService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], MovieService);
exports.MovieService = MovieService;
//# sourceMappingURL=movie.service.js.map