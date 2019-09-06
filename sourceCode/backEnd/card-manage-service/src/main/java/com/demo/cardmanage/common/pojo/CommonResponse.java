package com.demo.cardmanage.common.pojo;

/**
 * @Description 返回信息公共类
 * @author lixin
 */
public class CommonResponse {

	/**
	 * 状态码
	 */
	private String code;

	/**
	 * 附加信息
	 */
	private String msg;

	/**
	 * 返回数据
	 */
	private Object result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", msg=" + msg + ", result=" + result + "]";
	}

	/**
	 * 返回状态码及数据的构造方法
	 */
	public CommonResponse(String code, Object data) {
		super();
		this.code = code;
		this.result = data;
	}

	/**
	 * 返回状态码、错误信息的构造方法
	 */
	public CommonResponse(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 不带业务数据的成功响应
	 */
	public static CommonResponse success() {
		return new CommonResponse(Constants.Public.STATUS_SUCCESS, null);
	}

	/**
	 * 带业务数据的成功响应
	 */
	public static CommonResponse success(Object data) {
		return new CommonResponse(Constants.Public.STATUS_SUCCESS, data);
	}

	/**
	 * 返回异常代码及错误信息
	 */
	public static CommonResponse fail(String code, String msg) {
		return new CommonResponse(code, msg);
	}

	/**
	 * 只返回异常代码
	 */
	public static CommonResponse fail(String code) {
		return new CommonResponse(code, null);
	}

}
