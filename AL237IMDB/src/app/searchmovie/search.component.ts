import { Component } from '@angular/core';
import {Router} from '@angular/router';


@Component({
    selector: 'my-search',
    templateUrl: './search.component.html',
    styleUrls: [ './search.component.css' ]
})
export class SearchComponent {
    title = 'Tour of Dashboard';
    getData: string;

    constructor(private router: Router){}
   ontestGet(){
        /*this.httpService.getCurrentData()
            .subscribe(
            data => this.getData= JSON.stringify(data),
                error => alert(error),
                () => console.log('Finishe')
            );*/
        this.getData = 'bhas';
    }
}
