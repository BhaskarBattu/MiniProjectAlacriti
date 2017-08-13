import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";
import {AllSearch} from "./models/AllSearch";
import 'rxjs/add/operator/map'
// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import {AppComponentService} from "./app.component.service";
import 'rxjs/add/operator/switchMap';

import {SigninCmponent} from "./user-management/signin.cmponent"
import {SigninService} from "./user-management/signin.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  searchTh: AllSearch[];
  noresult: boolean;
  isloginers: false;
  username: any;

  private searchTerms = new Subject<string>();
  constructor(private router: Router, private route: ActivatedRoute,
              private  appComponentSevice: AppComponentService,
              private signinService: SigninService) { }

  search(term: string): void {
    if(term){
      this.appComponentSevice.search(term).debounceTime(200).distinctUntilChanged()
        .subscribe(data => {
          this.searchTh = data}
        );
    } else {
      this.searchTh =[];
      this.noresult=false;
    }

  }

  ngOnInit(): void {

    this.signinService.changes.subscribe(status =>this.isloginers= status);
    this.signinService.username.subscribe(name=>this.username =name);

  }


  onClickSignIn(){
    this.router.navigate(['/dashboard']);
  }
  gotoDetail(searchName: any) {
   this.router.navigate(['/search/'+ searchName, {searchItemName: searchName}]);
    this.searchTh =[];
    this.noresult=true;
  }

}
