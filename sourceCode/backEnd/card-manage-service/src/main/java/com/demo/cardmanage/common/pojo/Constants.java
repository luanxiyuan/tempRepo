package com.demo.cardmanage.common.pojo;

public interface Constants {

	/**
     * 公共常量
     */
    public static class Public {
        public static final String STATUS_SUCCESS = "0";
        public static final String STATUS_ERROR = "1";
    }
    
    /**
     * card 模块相关返回状态码
     */
    public static class CardContants{
    	public static final String LIST_CARDS_ERROR = "0101";// 获取用户下的卡信息失败
    	public static final String UPDATE_CARD_LIMIT_ERROR = "0102";// 修改卡额度失败
    }
}
