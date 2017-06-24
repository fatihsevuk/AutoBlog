package com.fatih.blogproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatih.blogproject.model.NotificationMessage;
import com.fatih.blogproject.model.NotificationMessageType;
import com.fatih.blogproject.service.NotifiacationService;

@Service
public class NotificationServiceImpl implements NotifiacationService{
	
	//Bu servis bilgi ve error mesajlarını HTTPSession içinde uzun süre tutmaya göre ayarlı olacak.
	//HTTPSession içinde veriler key value çifti olarak tututlurlar.
	
	 public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

	    @Autowired
	    private HttpSession httpSession;
	
	
	
	@Override
	public void addInfoMessage(String msg) {
		addNotificationMessage(NotificationMessageType.INFO, msg);
		
	}

	@Override
	public void addErrorMessage(String msg) {
		addNotificationMessage(NotificationMessageType.ERROR, msg);
		
	}
	
	private void addNotificationMessage(NotificationMessageType type , String msg){
		
		List<NotificationMessage> notifyMessage = (List<NotificationMessage>)httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
		
		if(notifyMessage==null){
			notifyMessage=new ArrayList<NotificationMessage>();
		}
		
		notifyMessage.add(new NotificationMessage(type, msg));
		
		httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessage);
		
		for (NotificationMessage notificationMessage : notifyMessage) {
			System.out.println(notificationMessage.getText());
			System.out.println(notificationMessage.getType());
		}
		
		
	}

}
