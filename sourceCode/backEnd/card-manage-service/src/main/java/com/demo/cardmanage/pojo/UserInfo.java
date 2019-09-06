package com.demo.cardmanage.pojo;

public class UserInfo {

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 用户性别:1男,2女
	 */
	private int sex;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", sex=" + sex + "]";
	}

}
