package com.app.demo.model.response;

import java.util.Date;

public class ErrorMessage {

	private String errorMessage;
	private Date timeStamp;
	
	public ErrorMessage() {}
	
	public ErrorMessage(String errorMessage, Date timeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
