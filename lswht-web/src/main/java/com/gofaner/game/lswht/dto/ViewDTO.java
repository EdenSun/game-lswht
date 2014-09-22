package com.gofaner.game.lswht.dto;

public class ViewDTO<T> {
	public static final String MSG_SUCCESS = "success";
	public static final String MSG_FAIL = "fail";
	public static final int CODE_SUCCESS = 0;
	public static final int CODE_ERROR = 1;
	
	private T data;
	private String msg;
	private int code;
	
	public ViewDTO() {
		super();
		msg = MSG_SUCCESS;
		code = CODE_SUCCESS;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
