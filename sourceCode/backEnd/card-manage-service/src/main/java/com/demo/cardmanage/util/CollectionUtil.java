package com.demo.cardmanage.util;

import java.util.Collection;

/**
 * 类名: CollectionUtil <br/>
 * 项目名称：card-manage-service <br/>
 * 创建人：lixin <br/>
 * 创建日期：2019.8.28 <br/>
 * 描述： 集合类基本操作 <br/>
 * 修改历史： <br/>
 */
public class CollectionUtil {
	/**
	 * 
	* @Title: nullOrEmpty  
	* @Description: 判断集合是否为空
	* @param  coll
	* @return boolean
	* @throws
	 */
	public static <T> boolean nullOrEmpty(Collection<? extends T> coll){
		if (coll == null || coll.size() <= 0 || coll.isEmpty()) {
			return true;
		}
		return false;
	}
}
