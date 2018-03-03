import {NgModule} from '@angular/core';
import {TypeaheadModule} from "./typeahead/typeahead.module";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";


@NgModule({
  imports: [TypeaheadModule, CommonModule, FormsModule],
  exports: [TypeaheadModule, CommonModule, FormsModule],
  declarations: [],
  providers: [],
})
export class SharedModule {
}
