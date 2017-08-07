import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class SigninService {
    constructor(private http: Http) { }
    public login(postData: any){
        return this.http.post('http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/checkUserLogin', postData);
    }
}
