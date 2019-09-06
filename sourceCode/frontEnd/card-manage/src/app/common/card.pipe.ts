import { Pipe, PipeTransform } from '@angular/core';
/*
replace
参数
  1：value为原数据
  2：replace为替换前数据以及替换后数据,以"-"进行分割
  	如a-b 期望结果为使用b替换a
 	如a 期望结果为使用空字符串替换a
*/
// @Pipe({ name: 'replace' })
// export class CardPipe implements PipeTransform {
//     transform(value: string): string {
//         value = value.replace('{', '');
//         return value.replace('}', '');
//     }
// }

@Pipe({ name: 'CardNumPipe' })
export class CardNumPipe implements PipeTransform {
  transform(value: any, mark: any): any {
    if (value) {
        let valueLength = value.length - 4;
        if(value.length < valueLength) {
            return value;
        }
        let result = "";
        for(let i=0;i<valueLength;i++) {
            result += "*";
        }
        return result + value.substring(value.length - 4, value.length);
    }
    return "";
  }
}
