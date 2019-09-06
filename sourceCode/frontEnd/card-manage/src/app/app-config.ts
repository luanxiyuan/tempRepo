import { Injectable } from '@angular/core';

@Injectable()
export class AppConfig {
  // Provide all the Application Configs here

  public baseApiPath: any = (<any>window).GLOBALCONFIG.baseApiPath;
  public userId: any = (<any>window).GLOBALCONFIG.userId;

  constructor() {
  }
}
