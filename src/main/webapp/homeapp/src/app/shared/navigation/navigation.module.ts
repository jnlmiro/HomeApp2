import {NavigationComponent} from "./navigation.component";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {FullScreenTogglingDirective} from "../directives/full-screen.toggling.directive";
import {DirectivesModule} from "../directives/directives.module";

@NgModule({
  imports: [RouterModule, DirectivesModule],
  exports: [NavigationComponent],
  declarations: [NavigationComponent],
  providers: [],
})
export class NavigationModule {
}
