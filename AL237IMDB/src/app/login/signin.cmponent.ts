import {Component, EventEmitter, Output} from '@angular/core';
import {Router} from '@angular/router';
import {SigninService} from './signin.service';
import {UtilityService} from '../utility.service';

@Component({
    selector: 'my-signin',
    templateUrl: './signin.component.html',
    styleUrls: [ './signin.component.css' ],
    outputs: ['getUserRes']
})
export class SigninCmponent
{
    @Output() onSubmitted = new EventEmitter<boolean>();
    @Output() onSubmittedRes = new EventEmitter<any>();
    postedData: string;
    postError: string;
    errorMsg: string;
    public response: any;
    public userResponse: any;
    public userLoginResponse: any;
    getUserRes= new EventEmitter<any>(this.userResponse = true);
    constructor(private router: Router,
                private signinService: SigninService,
                private utilityService: UtilityService){}
    onSubmitLogin(userLogin: any) {
        this.signinService.login(userLogin).subscribe((response) => {
            console.log(response);
            if (response.ok === true) {
                this.userLoginResponse = response.json();
                if (this.userLoginResponse === true) {
                    this.router.navigate(['/dashboard']);
                } else {
                    alert('Invalid user name plese log in');
                    this.router.navigate(['/Signin']);
                }
            }
        });
       /* let postData = {
            'email': email,
            'password': password,
        };*/
       /* console.log(userLogin);
        this.signinService.login(userLogin).subscribe((response) =>{
            console.log(response);
            if (response.ok === true) {
                    this.response = response.json();
                    // console.log(this.response);
                this.userResponse = this.response.name;
                   // console.log(this.response.name);
                    this.getUserRes.emit(this.response.name);
                    this.onSubmitted.emit(true);
                    this.onSubmittedRes.emit(this.response.name);
                    this.utilityService.setUserInfo(this.response.name);
                        if (this.responseRegistration === true) {
                            this.router.navigate(['/dashboard']);
                        } else {
                            alert('username is already exists plese log in');
                            this.router.navigate(['/Signin']);
                        }
            } else {
                alert('Please enter a valid username or password');
                this.router.navigate(['/Signin']);
            }
        });*/
        /*this.httpService.postData(uname, password)
            .subscribe(resEmployeeData => this.postedData = JSON.stringify(resEmployeeData),
                resEmployeeError => alert( resEmployeeError),
                () => console.log('Finished'));*/
    }
}
