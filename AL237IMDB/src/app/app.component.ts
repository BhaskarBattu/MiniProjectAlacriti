import {Component, OnInit} from '@angular/core';
import {UtilityService} from './utility.service';


@Component({
  selector: 'my-app',
    templateUrl: './app.component.html',
    styleUrls: [ './app.component.css' ]
})
export class AppComponent implements OnInit{
  title = 'Tour of Heroes';
    private user: string = '';
    isUserLoggedIn = false;
    public useRegname: String;
    // public userInfo = this.utilityService.userInfo;
    constructor(private utilityService: UtilityService) { }


    getUserName(): void {
     // console.log( this.utilityService.getUserInfo());
        this.utilityService.getUserInfo();
    }
    ngOnInit(): void {
       // console.log('App Component');
        this.getUserName();
        /*this.utilityService.getUserInfo().then(userInfo => {
          this.isUserLoggedIn = true;
            this.userInfo = userInfo;
        }).catch(() => {
          console.log('Rejected userInfo from utility clsses');
        });*/
    }
    onSubmitted(loggenIn: boolean) {
     // console.log('bhasi');
        this.isUserLoggedIn = true;
    }
    onSubmittedRes(logRes: any) {
        this.useRegname = logRes;
    }
}
