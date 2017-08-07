import {Injectable} from '@angular/core';



@Injectable()
export class UtilityService {
    public userInfo: any;
    getUserInfo() {
        if (this.userInfo){
           return Promise.resolve(this.userInfo);
        }
    }

    setUserInfo(userInfo: any) {
        this.userInfo = userInfo;
    }
}