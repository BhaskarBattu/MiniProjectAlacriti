import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class RegistrationService
{
    constructor(private http: Http) { }
    public registration(postRegistration: any) {
        return this.http.post ('http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/addUserRegistration', postRegistration);
    }

}