import {NavigationComponent} from "./navigation.component";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";

@NgModule({
  imports: [RouterModule],
  exports: [NavigationComponent],
  declarations: [NavigationComponent],
  providers: [],
})
export class NavigationModule {
}
