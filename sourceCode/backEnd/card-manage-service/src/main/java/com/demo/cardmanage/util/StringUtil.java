package com.demo.cardmanage.util;

/**
 * 类名: StringUtil <br/>
 * 项目名称：card-manage-service <br/>
 * 创建人：lixin <br/>
 * 创建日期：2019.8.28 <br/>
 * 描述： String类基本操作 <br/>
 * 修改历史： <br/>
 */
public class StringUtil {

	/**
    *
   * @Title: nullOrEmpty
   * @Description: 判断字符串是否为null或者""或者"null"
   * @param @param value
   * @param @return    参数
   * @return boolean    返回类型
   * @throws
    */
   public static boolean nullOrEmpty(String value) {
       if (value == null || "".equals(value) || "null".equals(value)) {
           return true;
       }
       return false;
   }
}
