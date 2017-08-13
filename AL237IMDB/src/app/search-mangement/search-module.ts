import {NgModule} from "@angular/core";
import {FormsModule} from '@angular/forms';
import {CommonModule} from "@angular/common";
import {AppRoutingModule} from '../app-routing.module';
import {ReactiveFormsModule} from '@angular/forms';
import {SearchComponent} from "./search.component";
import {SearchService} from "./search.service";


@NgModule({
  imports : [FormsModule, CommonModule, AppRoutingModule, ReactiveFormsModule],
  declarations : [SearchComponent],
  providers : [ SearchService ],
  exports : []
})

export class SearchModule{ }
