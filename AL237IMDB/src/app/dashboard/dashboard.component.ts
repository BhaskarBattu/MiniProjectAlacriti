import {Component, OnInit} from '@angular/core';
import {Hero} from '../hero/hero';
import { HeroService } from '../hero/hero.service';
import {Movie} from './movies/movie';
import {MovieService} from './movies/movie.service';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from 'rxjs/Observable';

@Component({
    selector: 'my-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
    title = 'Tour of Dashboard';
    moviesList: Movie[];
    heroes: Hero[] = [];

    observableMovies: Observable<Movie[]>
    errorMessage: String;

    constructor(private heroService: HeroService, private router: Router, private movieService: MovieService) { }
    ngOnInit(): void {
        this.observableMovies = this.movieService.getMoviesWithObservable();
        this.observableMovies.subscribe(
            moviesList => this.moviesList = moviesList,
            error => this.errorMessage = <any>error

        );
       /*this.heroService.getHeroes()
            .then(heroes => this.heroes = heroes.slice(1, 9));
        this.movieService.getMovies().then(movies => this.moviesList = movies.slice(0, 8));*/
    }
    onClickMovie(movieid: any, moviename: any, moviepath: any) {
        this.router.navigate(['/dashboard/MovieDescription/' + movieid, {id: movieid, moviename: moviename, movieImgPath: moviepath}]);
    }

}
