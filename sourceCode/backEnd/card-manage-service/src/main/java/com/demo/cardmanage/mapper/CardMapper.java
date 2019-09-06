package com.demo.cardmanage.mapper;

import java.util.List;

import com.demo.cardmanage.pojo.CardInfo;

/**
 * 类名: CardMapper <br/>
 * 项目名称：card-manage-service <br/>
 * 创建人：lixin <br/>
 * 创建日期：2019.8.28 <br/>
 * 描述： card mapper <br/>
 * 修改历史： <br/>
 */
public interface CardMapper {

	/**
	 * @Title listCardsByUserId
	 * @author lixin
	 * @Description: 根据用户id获取用户下的卡
	 * @param params
	 *            Integer userId
	 * @return List<CardInfo>
	 */
	List<CardInfo> listCardsByUserId(Integer userId);
	
	/**
	 * @Title getCardInfo
	 * @author lixin
	 * @Description: 根据card id获取卡详情
	 * @param params
	 *            Integer cardId
	 * @return CardInfo
	 */
	CardInfo getCardInfo(Integer cardId);

	/**
	 * @Title updateCardQuota
	 * @author lixin
	 * @Description: 修改卡的额度
	 * @param params
	 *            CardInfo cardInfo
	 * @return List<CardInfo>
	 */
	int updateCardQuota(CardInfo cardDO);
}
