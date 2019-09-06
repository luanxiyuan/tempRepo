package com.demo.cardmanage.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CardInfo {

	/**
	 * 卡主键id
	 */
	private Integer cardId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 卡名称
	 */
	private String cardName;
	/**
	 * 卡号
	 */
	private String cardNumber;
	/**
	 * 总额度
	 */
	private BigDecimal quota;
	/**
	 * 已用额度
	 */
	private BigDecimal alreadyQuota;
	/**
	 * 可用额度
	 */
	private BigDecimal availableQuota;
	/**
	 * 创建人
	 */
	private Integer createUser;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建时间String
	 */
	private String createTime;
	/**
	 * 修改人
	 */
	private Integer updateUser;
	/**
	 * 修改时间
	 */
	private Date updateDate;
	/**
	 * 修改时间String
	 */
	private String updateTime;
	/**
	 * 卡片下拉展示值
	 */
	private String label;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public BigDecimal getQuota() {
		return quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}

	public BigDecimal getAlreadyQuota() {
		return alreadyQuota;
	}

	public void setAlreadyQuota(BigDecimal alreadyQuota) {
		this.alreadyQuota = alreadyQuota;
	}

	public BigDecimal getAvailableQuota() {
		return availableQuota;
	}

	public void setAvailableQuota(BigDecimal availableQuota) {
		this.availableQuota = availableQuota;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "CardInfo [cardId=" + cardId + ", userId=" + userId + ", cardName=" + cardName + ", cardNumber="
				+ cardNumber + ", quota=" + quota + ", alreadyQuota=" + alreadyQuota + ", availableQuota="
				+ availableQuota + ", createUser=" + createUser + ", createDate=" + createDate + ", createTime="
				+ createTime + ", updateUser=" + updateUser + ", updateDate=" + updateDate + ", updateTime="
				+ updateTime + ", label=" + label + "]";
	}

}
