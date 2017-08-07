import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class MovieDescrptionService {
    constructor(private http: Http) { }
    public getMovieDetails(movieName: any)
    {
        event.preventDefault();
        let moviedata = {
            'moviename': movieName
        };
        return this.http.post('http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/movieDetails', moviedata);
    }
}