import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
@Injectable()
export class SigninService {
  changes:BehaviorSubject<any> = new BehaviorSubject(false);
  username:BehaviorSubject<any> = new BehaviorSubject("zzxz");
    constructor(private http: Http) { }
    public login(postData: any){
      const headers = new Headers();
      headers.append('Content-Type',
        'application/json');
         return this.http.post('http://localhost:8080/IMDBRating-0.0.1-SNAPSHOT/user/checkUserLogin',
            postData,{ headers: headers,withCredentials:true});
    }
    /*if(postData)
    {
      this.changes.next(true);
    }*/
}
