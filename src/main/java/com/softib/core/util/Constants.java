package com.softib.core.util;

public interface Constants {
	String MAIL_VALIDATION_PATTERN="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\\\[[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\\\-0-9]+\\\\.)+[a-zA-Z]{2,}))$";
	String PASSWORD_VALIDATION_PATTERN="^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
	String MAIL="soft.ib55@gmail.com";
	String PASSWORD="gogogogogogogogog";
	String PUSH_SERVER_URI="http://soft-ib-push-server:8785/push";


}
