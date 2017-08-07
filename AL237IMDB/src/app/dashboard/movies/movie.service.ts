import { Injectable } from '@angular/core';
import {MovieNames} from './movie-names';
import {Movie} from './movie';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class MovieService {
    private Url = 'api/dashboard/MovieDescription';
    private movieUrl= 'http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/movieDetails';
    constructor (private http: Http) {}

    getMoviesWithObservable(): Observable<Movie[]> {
            return this.http.get(this.movieUrl)
                .map(this.extractMovieData)
                .catch(this.handleErrorObservable);
    }
    private  extractMovieData(res: Response) {
        let body = res.json();
        return body;

    }
    private handleErrorObservable (error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.message || error);
    }

    getMovies(): Promise<Movie []> {
        return Promise.resolve(MovieNames);
    }

    getMoviesSlowly(): Promise<Movie[]> {
        return new Promise(resolve => {
            // Simulate server latency with 2 second delay
            setTimeout(() => resolve(this.getMovies()), 2000);
        });
    }
}