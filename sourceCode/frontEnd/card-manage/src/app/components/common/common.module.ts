import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [];
@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    NgZorroAntdModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
  providers: [
  ]
})
export class CommonModule {

}
