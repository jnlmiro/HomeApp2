import {NgModule} from '@angular/core';
import {TypeaheadModule} from "./typeahead/typeahead.module";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {NavigationModule} from "./navigation/navigation.module";


@NgModule({
  imports: [TypeaheadModule, NavigationModule, CommonModule, FormsModule],
  exports: [TypeaheadModule, NavigationModule, CommonModule, FormsModule],
  declarations: [],
  providers: [],
})
export class SharedModule {
}
