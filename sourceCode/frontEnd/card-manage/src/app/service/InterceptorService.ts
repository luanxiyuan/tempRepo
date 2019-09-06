import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from './ApiService';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import {
    HttpInterceptor,
    HttpRequest,
    HttpHandler,
    HttpErrorResponse,
    HttpHeaderResponse,
    HttpResponse,
    HttpEvent
} from '@angular/common/http';
import { mergeMap } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
@Injectable()
export class InterceptorService implements HttpInterceptor {

    constructor(
        private apiService: ApiService,
        private router: Router) {
    }
    loginName: any; // 当前登录用户名

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // 这里可以在请求中加参数
        const req = request.clone({
            // url: (request.url + '&token=ujusaruu19')
        });
        const me = this;
        return next.handle(req)
            .pipe(
                /*失败时重试2次，可自由设置*/
                // retry(2),
                /*捕获响应错误，可根据需要自行改写，我偷懒了，直接用的官方的*/
                catchError(this.handleData)
            )
    }

    private handleData(
        event: HttpResponse<any> | HttpErrorResponse,
    ): Observable<any> {
        // 业务处理：一些通用操作
        switch (event.status) {
            case 200:
                break;
            case 401: // 未登录状态码
                console.log('status 401');
                break;
            case 404:
                console.log('status 404');
                break;
            case 500:
                console.log('status 500');
                break;
            default:
                return;
        }
    }
}
