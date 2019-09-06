import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { NgZorroAntdModule, NZ_I18N, en_US } from 'ng-zorro-antd';
import { AppRoutes } from './app.routes';
import { AppConfig } from './app-config';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import zh from '@angular/common/locales/zh';
import { registerLocaleData } from '@angular/common';
import { NgxEchartsModule } from 'ngx-echarts';
import { ApiService } from './service/ApiService';
import { InterceptorService } from './service/InterceptorService';
import { HttpModule } from '@angular/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpErrorHandler } from './service/http-error-handler.service';
import { MessageService } from './service/message.service';
import { NgCircleProgressModule } from 'ng-circle-progress';

registerLocaleData(zh);
/* begin */
import {
    CardmanageComponent,
    CardmanageService
 } from './components';
/* end */

import {
    EmitService
} from './service';

/*pipe*/
import {
    CardNumPipe
} from './common/card.pipe';

@NgModule({
    declarations: [
        CardmanageComponent,
        AppComponent,
        CardNumPipe
    ],
    imports: [
        BrowserModule,
        NgZorroAntdModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        AppRoutes,
        NgxEchartsModule,
        HttpModule,
        NgCircleProgressModule.forRoot({
            radius: 100,
            outerStrokeWidth: 16,
            innerStrokeWidth: 8,
            outerStrokeColor: "#78C000",
            innerStrokeColor: "#C7E596",
            animationDuration: 300
        })
    ],
    exports: [
    ],
    providers: [
        AppConfig,
        ApiService,
        EmitService,
        CardmanageService,
        InterceptorService,
        HttpErrorHandler,
        MessageService,
        { provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true }
        // { provide: NZ_I18N, useValue: en_US }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
