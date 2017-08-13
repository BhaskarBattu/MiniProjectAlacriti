import {Component, OnInit} from '@angular/core';
import {RegistrationService} from './registration.service';
import {Router} from '@angular/router';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {SigninService} from "./signin.service";

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: [ './registration.component.css' ]
})
export class RegistrationComponent implements  OnInit{
    public responseRegistration: any;
    userForm: FormGroup;

    constructor(private regService: RegistrationService,
                private router: Router, private _formBuilder: FormBuilder,
                private signinService: SigninService) { }

    ngOnInit() {
        this.userForm = this._formBuilder.group({
            firstName: ['', [Validators.required, Validators.minLength(4)]],
            lastName: ['', [Validators.required, Validators.minLength(4)]],
            email: ['', [Validators.required, Validators.minLength(4)]],
            password: ['', [Validators.required, Validators.minLength(8)]],
            passwordRepeat: ['', [Validators.required, Validators.minLength(8)]],
            address: ['', [Validators.required, Validators.minLength(4)]],
            mobileno: ['', [Validators.pattern('^[ 7-9][0-9]{9}$'), Validators.required,
                        Validators.minLength(10), Validators.maxLength(10)]]
        });
    }
    onSubmit() {
        console.log(this.userForm.value);
        this.regService.registration(this.userForm.value).subscribe((response) => {
            console.log(response);
            if (response.ok === true) {
                // if (response.status === 200) {
                this.responseRegistration = response.json();
                console.log(this.responseRegistration);
                if (this.responseRegistration === true) {
                  this.signinService.changes.next(true);
                  this.signinService.username.next(this.userForm.value.email);
                    this.router.navigate(['/']);
                } else {
                    alert('username is already exists plese log in');
                    this.router.navigate(['/signin']);
                }
            }
        });
    }
}
