import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/switchMap';
import {Movie} from '../movie';
import {MovieService} from '../movie.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {MovieDescrptionService} from "./movieDescrption.service";

@Component({
    selector: 'my-moviedescription',
    templateUrl: './moviedescription.component.html',
    styleUrls: [ './moviedescription.component.css' ]
})
export  class MoviedescriptionComponent implements OnInit {
    movie: Movie;
    parseId: any;
    parseMovie: any;
    parseMoviePath: any;
    moviesList: Movie [] = [];
    movieResponsePrint: any;
    constructor (private movieService: MovieService,
                 private movieDescService: MovieDescrptionService,
                 private route: ActivatedRoute, private router: Router ) { }
    /*ngOnInit(): void {
        // console.log('bhsl');
        this.route.paramMap.switchMap((params: ParamMap) => this.movieService.getMovieName(+params.get('id')))
            .subscribe(movie => this.movie = movie);
        // this.movieService.getMovies().then(movies => this.moviesList = movies.slice(0, 8));
    }*/
    ngOnInit(): void {
        this.route.params
            .subscribe((params: ParamMap) => { this.parseId = params['id'],
                this.parseMovie = params['moviename'], this.parseMoviePath = params['movieImgPath']; });
        this.movieDescService.getMovieDetails(this.parseMovie)
            .subscribe((movieResponse) => {
                this.movieResponsePrint = movieResponse.json();
                console.log('bhasi');
                console.log(this.movieResponsePrint);
            });

    }
    goBack(): void {
        this.router.navigate(['/dashboard']);
    }
}