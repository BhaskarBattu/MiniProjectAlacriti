import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here

import { AppComponent }  from './app.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {SearchComponent} from './searchmovie/search.component';
import {RegistrationComponent} from './login/registration.component';
import {SigninCmponent} from './login/signin.cmponent';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {HttpModule} from '@angular/http';
import {HeroService} from './hero/hero.service';
import {SigninService} from './login/signin.service';
import {RegistrationService} from './login/registration.service';
import {UtilityService} from './utility.service';
import {MovieService} from './dashboard/movies/movie.service';
import {MoviedescriptionComponent} from './dashboard/movies/moviedescription/moviedescription.component';
import {DashboardService} from './dashboard/dashboard.service';
import {MovieDescrptionService} from './dashboard/movies/moviedescription/movieDescrption.service';



@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
      AppRoutingModule,
      HttpModule// <-- import the FormsModule before binding with [(ngModel)]
  ],
  declarations: [
    AppComponent,
      DashboardComponent,
      SearchComponent,
      RegistrationComponent,
      SigninCmponent,
      MoviedescriptionComponent

  ],
    providers: [ HeroService, MovieDescrptionService , DashboardService, SigninService, RegistrationService, UtilityService, MovieService],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
