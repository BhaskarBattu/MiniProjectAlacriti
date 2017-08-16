import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/switchMap';

import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {SigninService} from "./signin.service";
import {FormBuilder} from "@angular/forms";
import {LogoutService} from "./logout.service";
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: [ './logout.component.css' ]
})

export  class LogoutComponent implements OnInit{
  isLogoutuser: any;
  constructor(private router: Router,
              private signinService: SigninService,
              private _formBuilder: FormBuilder,
              private logoutservice: LogoutService) { }
  ngOnInit() {
      this.logoutservice.logout().subscribe(
        response => {
          if (response.ok === true) {
            this.isLogoutuser = response.json();
            if (this.isLogoutuser !== true) {
              alert('please try again');
              this.router.navigate(['/']);
            } else {
              this.signinService.changes.next(false);
              this.signinService.referehbrowser.next(false);
              this.signinService.username.next("null");
              window.localStorage.removeItem('username');
              window.localStorage.removeItem('valid');
              alert('you are successfully logged out');
              this.router.navigate(['/']);
            }
          }

        });

  }

}
