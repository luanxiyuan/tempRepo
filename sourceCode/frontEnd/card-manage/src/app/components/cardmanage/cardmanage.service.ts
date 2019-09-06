import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ApiService } from '../../service/ApiService';
import {AppConfig} from '../../app-config';

@Injectable()
export class CardmanageService {

    constructor(
        private appConfig: AppConfig,
        private apiService: ApiService) {
        }

    // 根据用户id获取用户下的卡
    listCards(): Observable<any> {
        const that = this;
        const subject = new Subject<any>();
        that.apiService.get('/card/list/' + that.appConfig.userId).subscribe(res => {
            subject.next(res);
        });
        return subject;
    }

    // 获取曲线图数据 number=1
    updateCardQuota(param): Observable<any> {
        const me = this;
        const subject = new Subject<any>();
        me.apiService.put('/card/update', param).subscribe(res => {
            subject.next(res);
        });
        return subject;
    }

}
