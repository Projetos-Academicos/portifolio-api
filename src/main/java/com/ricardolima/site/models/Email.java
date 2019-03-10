package com.ricardolima.site.models;

public class Email {

	private String name;
	private String email;
	private String subject;
	private String message;

	public Email () {

	}

	public Email(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public String getEmail() {
		return this.email;
	}
	public String getMessage() {
		return this.message;
	}
	public String getName() {
		return this.name;
	}
	public String getSubject() {
		return this.subject;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
