package com.vwits.orderservice.dto.request;

public class UpdateStatuRequest {
private String status;

public UpdateStatuRequest(String status) {
	super();
	this.status = status;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}
