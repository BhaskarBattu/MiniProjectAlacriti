import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';
import {SigninService} from './signin.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {BehaviorSubject} from "rxjs/BehaviorSubject";


@Component({
    selector: 'app-signing',
    templateUrl: './signin.component.html',
    styleUrls: [ './signin.component.css' ],
    outputs: ['getUserRes']
})
export class SigninCmponent implements OnInit
{

    userForm: FormGroup;

    public userLoginResponse: any;
    @Output() getUserRes: EventEmitter<any>= new EventEmitter<any>(); // (this.userResponse = true);
    constructor(private router: Router,
                private signinService: SigninService,
                private _formBuilder: FormBuilder) { }
    ngOnInit() {
        this.userForm = this._formBuilder.group({
            email: ['', [Validators.required, Validators.minLength(4)]],
            password: ['', [Validators.required, Validators.minLength(8)]]

        });
    }
    onSubmit() {

      this.signinService.login(this.userForm.value).subscribe((response) => {
            if (response.ok === true) {
                this.userLoginResponse = response.json();
                if (this.userLoginResponse !== true) {
                    alert('Invalid user name plese log in');
                    this.router.navigate(['/signin']);
                } else {
                   this.getUserRes.emit(this.userForm.value.email);
                   window.localStorage.setItem('username',this.userForm.value.email)
                  window.localStorage.setItem('valid','true');
                  this.signinService.changes.next(true);
                  this.signinService.referehbrowser.next(true);
                   this.signinService.username.next(this.userForm.value.email);
                   //console.log(this.userForm.value.email);
                   this.router.navigate(['/']);
                }
            }
        });
    }

}
