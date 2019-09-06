package com.demo.cardmanage.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.cardmanage.common.pojo.CommonResponse;
import com.demo.cardmanage.common.pojo.Constants;
import com.demo.cardmanage.mapper.CardMapper;
import com.demo.cardmanage.pojo.CardInfo;
import com.demo.cardmanage.service.CardService;

/**
 * 类名: CardServiceImpl <br/>
 * 项目名称：card-manage-service <br/>
 * 创建人：lixin <br/>
 * 创建日期：2019.8.28 <br/>
 * 描述： card 业务实现类 <br/>
 * 修改历史： <br/>
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

	private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);
	
	@Autowired
	private CardMapper cardMapper;
	
	@Override
	public CommonResponse listCardsByUserId(Integer userId) {
		logger.debug("listCardsByUserId: params= " + userId);
		if(null == userId) {
			logger.error("listCardsByUserId: param error, userId is null!");
			return CommonResponse.fail(Constants.CardContants.LIST_CARDS_ERROR, "param error, userId is null");
		}
		List<CardInfo> cardList = cardMapper.listCardsByUserId(userId);
		// 计算可用额度
		cardList.forEach(item -> {
			item.setAvailableQuota(item.getQuota().subtract(item.getAlreadyQuota()));
			item.setLabel(item.getCardName());
		});
		return CommonResponse.success(cardList);
	}

	@Override
	public CommonResponse updateCardQuota(CardInfo cardInfo) {
		
		// 获取卡详情
		CardInfo cardInfoRes = cardMapper.getCardInfo(cardInfo.getCardId());
		if(null == cardInfoRes) {
			return CommonResponse.fail(Constants.CardContants.UPDATE_CARD_LIMIT_ERROR,"not found card from database, cardId= " + cardInfo.getCardId());
		}
		cardInfoRes.setQuota(cardInfo.getQuota());
		cardInfoRes.setUpdateUser(cardInfo.getUserId());
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cardInfoRes.setUpdateTime(format.format(date));
		// 校验值是否非法
		if(!checkQuotaValue(cardInfoRes.getQuota(), cardInfoRes.getAlreadyQuota())) {
			return CommonResponse.fail(Constants.CardContants.UPDATE_CARD_LIMIT_ERROR,"quota or alreadyQuota is not valid, can't be null and must more than already quota!");
		}
		int updateResult = cardMapper.updateCardQuota(cardInfoRes);
		if(1 != updateResult) {
			return CommonResponse.fail(Constants.CardContants.UPDATE_CARD_LIMIT_ERROR, "update card quota to database error!");
		}
		return CommonResponse.success();
	}
	
	/**
	 * 1、判断额度值是否为空
	 * 2、判断额度值是否为0和负数
	 * 3、判断额度值是否小于已用额度
	 * 如果满足上述任一条件则返回false,不满足返回true
	 */
	private boolean checkQuotaValue(BigDecimal quota, BigDecimal alreadyQuota) {
		
		if(null == quota || null == alreadyQuota) {
			// 判断不能为空
			return false;
		}else if(quota.signum() == 0 || quota.signum() == -1) {
			// 判断不能为0或负数
			return false;
		}else if(quota.compareTo(alreadyQuota)  == -1) {
			 // 判断如果额度小于已用额度则返回错误(a.compareTo(b)等于-1则a小于b,等于0则a等于b,等于1则a大于b)
			return false;
		}
		return true;
	}

}
