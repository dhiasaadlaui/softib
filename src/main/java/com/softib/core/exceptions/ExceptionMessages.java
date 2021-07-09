package com.softib.core.exceptions;

public interface ExceptionMessages {
	//USER VALIDATION
	String	MANDATORY_USERNAME = "User name is mandatory";
	String	MANDATORY_MAIL = "Email is mandatory";
	String	INVALID_MAIL_FORMAT = " Invalid mail  format ! ";
	String	MANDATORY_PASSWORD = "Password is mandatory";
	String	INVALID_PASSWORD_FORMAT = "Must have at least one numeric character\r\n" + 	"Must have at least one lowercase character\r\n" + 	"Must have at least one uppercase character\r\n" + "Must have at least one special symbol among @#$%\r\n" + 	"Password length should be between 8 and 20";
	String	INVALID_ACTIVATION_KEY = "Incorrect Activation key";

	//ADRESS VALIDATION
	String	MANDATORY_STREET = "Mandatory street";
	String	MANDATORY_STREET_NUMBER = "Mandatory street number";
	String	MANDATORY_POSTAL_CODE = "Mandatory postal code";
	String 	MANDATORY_GOVERMENT="Mandatory goverment";

	
}
