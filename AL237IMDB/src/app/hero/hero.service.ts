import { Hero } from '../hero/hero';
import { HEROES } from '../hero/mock-heroes';
import { Injectable } from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class HeroService {
  /*  private moviesUrl = 'api/movies';
    constructor(private http: Http) { }*/
    getHeroes(): Promise<Hero[]> {
        return Promise.resolve(HEROES);
    }

    getHeroesSlowly(): Promise<Hero[]> {
        return new Promise(resolve => {
            // Simulate server latency with 2 second delay
            setTimeout(() => resolve(this.getHeroes()), 2000);
        });
    }

    getHero(id: number): Promise<Hero> {

        return this.getHeroes()
            .then(heroes => heroes.find(hero => hero.id === id));
    }
}
