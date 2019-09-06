package com.demo.cardmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cardmanage.common.pojo.CommonResponse;
import com.demo.cardmanage.pojo.CardInfo;
import com.demo.cardmanage.service.CardService;

/**
 * @ClassName: CardController
 * @Description: card controller
 * @author lixin
 * @date 2019.8.28
 */
@RestController
@RequestMapping(value = "/card")
public class CardController {

	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;

	/**
	 * 根据用户id获取用户下的卡
	 * 
	 * @param Integer
	 *            userId
	 * @return CommonResponse
	 */
	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public CommonResponse listCardsByUserId(@PathVariable Integer userId) {
		logger.debug("listCardsByUserId: params= " + userId);
		return cardService.listCardsByUserId(userId);
	}

	/**
	 * 修改卡的额度
	 * 
	 * @param CardDO
	 *            cardInfo
	 * @return CommonResponse
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public CommonResponse updateCardQuota(@RequestBody CardInfo cardInfo) {
		logger.debug("listCardsByUserId: params= " + cardInfo);
		return cardService.updateCardQuota(cardInfo);
	}
}
