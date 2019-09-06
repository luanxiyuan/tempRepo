import { Component, OnInit } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd';
import {AppConfig} from '../../app-config';
import { CardmanageService } from './cardmanage.service';

@Component({
    selector: 'app-home',
    templateUrl: './cardmanage.component.html',
    styleUrls: ['./cardmanage.component.css']
})

export class CardmanageComponent implements OnInit {

    
    cardSelected: any;// 当前选中卡片
    cardOptions: any;// 卡片下拉值
    cardImgPath: string;// 卡片图片地址
    cardNumber: string;// 卡号
    limitUnit = "$ ";// 默认单位
    limit: number;// 总额度
    availableProportion: number;// 可用额度占比
    availableSubtitle= "";// 可用额度
    newLimit: number;// 新额度
    size="large";// 按钮大小
    cardMainPage=true;// 控制主页面展示
    cardSuccessPage=false;// 控制成功面展示
    cardErrorPage=false;// 控制失败面展示
    errorMsg: string;// 修改额度返回错误信息
    updateDate: string;// 修改时间
    formatterDollar = (value: number) => `$ ${value}`;
    parserDollar = (value: string) => value.replace('$ ', '');

    constructor(
        private appConfig: AppConfig,
        private service: CardmanageService,
        private message: NzMessageService) {
    }

    ngOnInit() {
        this.initCardData();
    }

    initCardData() {
        const that = this;
        that.cardOptions = [];
        // 根据用户id获取用户下的卡
        that.service.listCards().subscribe((cardRes) => {
            if(cardRes.code == 0) {
                that.cardOptions = cardRes.result;
                // 如果有返回值，为下拉框赋值并初始化
                if(that.cardOptions.length > 0) {
                    that.cardSelected = that.cardOptions[0];
                    that.changeCard(that.cardSelected);
                }
            }else {
                that.message.create('error', cardRes.msg == null ? "get cards error!" : cardRes.msg);
            }
        });
    }

    changeCard(param) {
        const that = this;
        that.cardNumber = param.cardNumber;
        that.availableSubtitle = that.limitUnit + param.availableQuota;
        that.limit = param.quota;
        that.newLimit = param.quota;
        that.availableProportion = that.getProportion(param.quota, param.availableQuota);
    }

    // 获取已用额度百分比
    getProportion(limit, availableLimit) {
        let result = Math.round(availableLimit / limit * 100);
       return result < 0 ? 0 : result;
    }

    // 修改额度
    updateCardQuota() {
        const that = this;
        // 如果没有修改额度则不发请求
        if(that.newLimit == that.limit) {
            return that.message.create('warning', 'The new limit is not the same as the old limit!');
        }

        let param = {
            "userId": that.appConfig.userId,
            "cardId": that.cardSelected.cardId,
            "quota": that.newLimit
        }
        that.service.updateCardQuota(param).subscribe((updateRes) => {
            if(updateRes.code == 0) {
                that.updateDate = that.formatDate(new Date);
                that.goToSuccess();
            }else {
                that.errorMsg = updateRes.msg;
                that.goToFailed();
            }
        });
    }

    // 返回主页
    backToIndex() {
        this.initCardData();
        this.cardMainPage=true;
        this.cardSuccessPage=false;
        this.cardErrorPage=false;
    }
    // 跳转到成功页
    goToSuccess() {
        this.cardMainPage=false;
        this.cardSuccessPage=true;
        this.cardErrorPage=false;
    }
    // 跳转到失败页
    goToFailed() {
        this.cardMainPage=false;
        this.cardSuccessPage=false;
        this.cardErrorPage=true;
    }

    formatDate(timeStamp) {
        let now = new Date(timeStamp);
        let year = now.getFullYear();
        let month = now.getMonth() + 1;
        let date = now.getDate();
        let hour = now.getHours();
        let minute = now.getMinutes();
        let second = now.getSeconds();
        let addZero=function(data){
                return data < 10 ? '0' + data : data
        };
        return year + "/" + addZero(month) + "/" + addZero(date);
      }

}
