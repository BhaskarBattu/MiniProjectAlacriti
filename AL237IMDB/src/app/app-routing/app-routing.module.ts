import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from '../dashboard/dashboard.component';
import {SearchComponent} from '../searchmovie/search.component';
import {SigninCmponent} from '../login/signin.cmponent';
import {RegistrationComponent} from '../login/registration.component';
import {MoviedescriptionComponent} from '../dashboard/movies/moviedescription/moviedescription.component';

const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard',  component: DashboardComponent },
    { path: 'Search', component: SearchComponent },
    { path: 'Signin',     component: SigninCmponent },
    { path: 'Login',     component: RegistrationComponent },
    { path: 'dashboard/MovieDescription/:id',  component: MoviedescriptionComponent}
    ];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
