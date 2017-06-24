package com.fatih.blogproject.model;

public class NotificationMessage {
	
	
	private NotificationMessageType type;
    private String text;
	
	public NotificationMessage(NotificationMessageType type, String text) {
        this.type = type;
        this.text = text;
    }

    public NotificationMessageType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
	
	

