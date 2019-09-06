import {Injectable} from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import {AppConfig} from '../app-config';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';

import {HttpErrorHandler, HandleError} from './http-error-handler.service';

@Injectable()
export class ApiService {

  private handleError: HandleError;

  constructor(
    private http: HttpClient,
    private appConfig: AppConfig,
    httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('ApiService');
  }

  getRequestOptions(httpParams?: HttpParams, body?: Object): any {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
    };
    if (httpParams) {
      httpOptions['search'] = httpParams;
    }
    if (body) {
      httpOptions['body'] = body;
    }
    return httpOptions;
  }

  get(url: string, httpParams?: HttpParams): Observable<any> {
    const that = this;
    const requestOptions = that.getRequestOptions(httpParams, undefined);
    return that.http.get(that.appConfig.baseApiPath + url, requestOptions)
      .pipe(
      catchError(that.handleError('get', []))
      );
  }

  post(url: string, body: Object): Observable<any> {
    const that = this;
    const requestOptions = that.getRequestOptions(undefined, body);
    return that.http.post(that.appConfig.baseApiPath + url, body, requestOptions)
      .pipe(
      catchError(that.handleError('post', []))
      );
  }

  put(url: string, body: Object): Observable<any> {
    const that = this;
    const requestOptions = that.getRequestOptions(undefined, body);
    return that.http.put(that.appConfig.baseApiPath + url,body, requestOptions)
      .pipe(
      catchError(that.handleError('put', []))
      );
  }

  delete(url: string): Observable<any> {
    const that = this;
    const requestOptions = that.getRequestOptions(undefined, undefined);
    return that.http.delete(that.appConfig.baseApiPath + url, requestOptions)
      .pipe(
      catchError(that.handleError('delete', []))
      );
  }

}

