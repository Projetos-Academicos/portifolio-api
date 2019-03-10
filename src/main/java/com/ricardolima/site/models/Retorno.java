package com.ricardolima.site.models;

public class Retorno {

	private String msg;

	public Retorno() {

	}

	public Retorno (String msg) {
		this.setMsg(msg);
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
