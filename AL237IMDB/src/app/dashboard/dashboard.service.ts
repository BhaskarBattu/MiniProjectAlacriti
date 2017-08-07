import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {MovieService} from './movies/movie.service';
import { Router} from '@angular/router';

@Injectable()
export class DashboardService {
    constructor (private movieService: MovieService, private router: Router) { }

}