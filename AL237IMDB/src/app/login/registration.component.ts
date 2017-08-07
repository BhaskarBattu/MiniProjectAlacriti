import { Component } from '@angular/core';
import {RegistrationService} from './registration.service';
import {Router} from '@angular/router';


@Component({
    selector: 'my-registration',
    templateUrl: './registration.component.html',
    styleUrls: [ './registration.component.css' ]
})
export class RegistrationComponent {
    public responseRegistration: any;
    constructor(private regService: RegistrationService, private router: Router) { }
    onSubmit(userReg: any)
    {
        console.log(userReg);
        this.regService.registration(userReg).subscribe((response) => {
             //console.log(response);
           if (response.ok === true) {
            // if (response.status === 200) {
                this.responseRegistration = response.json();
                console.log(this.responseRegistration);
                if (this.responseRegistration === true) {
                    this.router.navigate(['/dashboard']);
                } else {
                    alert('username is already exists plese log in');
                    this.router.navigate(['/Signin']);
                }
           }
        });
    }
}
