package com.sty.message.request;

public class RequestEventMessage extends RequestMessage {
	
	private String Event;
	private String EventKey;
	private String Ticket;
	
	//上报地理位置事件
	private String Latitude;
	private String Longitude;
	private String Precision;
	
	
	
	public RequestEventMessage() {
		super();
	}
	public RequestEventMessage(String event, String eventKey, String ticket, String latitude, String longitude,
			String precision) {
		super();
		Event = event;
		EventKey = eventKey;
		Ticket = ticket;
		Latitude = latitude;
		Longitude = longitude;
		Precision = precision;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
}
