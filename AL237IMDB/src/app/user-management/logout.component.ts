import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/switchMap';

import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {SigninService} from "./signin.service";
import {FormBuilder} from "@angular/forms";
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: [ './logout.component.css' ]
})

export  class LogoutComponent implements OnInit{
  constructor(private router: Router,
              private signinService: SigninService,
              private _formBuilder: FormBuilder) { }
  ngOnInit() {
    this.signinService.changes.next(false);
    this.signinService.username.next("null");
    alert('you are successfully logged out');
    this.router.navigate(['/']);
  }

}
