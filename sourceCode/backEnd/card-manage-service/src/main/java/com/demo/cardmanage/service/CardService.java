package com.demo.cardmanage.service;

import com.demo.cardmanage.common.pojo.CommonResponse;
import com.demo.cardmanage.pojo.CardInfo;

/**
 * 类名: CardService <br/>
 * 项目名称：card-manage-service <br/>
 * 创建人：lixin <br/>
 * 创建日期：2019.8.28 <br/>
 * 描述： card service <br/>
 * 修改历史： <br/>
 */
public interface CardService {

	/**
	 * 根据用户id获取用户下的卡
	 */
	CommonResponse listCardsByUserId(Integer userId);

	/**
	 * 修改卡片额度
	 */
	CommonResponse updateCardQuota(CardInfo cardInfo);
}
