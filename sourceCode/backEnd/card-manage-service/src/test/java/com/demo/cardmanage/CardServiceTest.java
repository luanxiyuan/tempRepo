package com.demo.cardmanage;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.cardmanage.common.pojo.CommonResponse;
import com.demo.cardmanage.pojo.CardInfo;
import com.demo.cardmanage.service.CardService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

	@Autowired
	private CardService cardService;

	@Test
	public void listCardsByUserIdTest() {
		Integer userId = 1;
		CommonResponse response = cardService.listCardsByUserId(userId);
		System.out.println(response);
	}

	@Test
	public void updateCardQuota() {
		CardInfo cardInfo = new CardInfo();
		cardInfo.setUserId(1);
		cardInfo.setCardId(1);
		cardInfo.setQuota(new BigDecimal("2000"));
		CommonResponse response = cardService.updateCardQuota(cardInfo);
		System.out.println(response);
	}

}
