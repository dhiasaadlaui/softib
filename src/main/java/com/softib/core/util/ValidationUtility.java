package com.softib.core.util;

import org.springframework.stereotype.Service;

import com.softib.core.entities.User;
import com.softib.core.exceptions.ExceptionMessages;
import com.softib.core.exceptions.UserValidationException;

@Service
public class ValidationUtility {

	public void validateUser(User user) throws UserValidationException {

		if (user.getUsername() == null) {
			throw new UserValidationException(ExceptionMessages.MANDATORY_USERNAME);
		}
		if (user.getPassword() == null) {
			throw new UserValidationException(ExceptionMessages.MANDATORY_PASSWORD);
		}
		if (!isValidPassword(user.getPassword())) {
			throw new UserValidationException(ExceptionMessages.INVALID_PASSWORD_FORMAT);
		}
		if (user.getEmail() == null) {
			throw new UserValidationException(ExceptionMessages.INVALID_MAIL_FORMAT);
		}
		if (!isValidEmailAddress(user.getEmail())) {
			throw new UserValidationException(ExceptionMessages.INVALID_MAIL_FORMAT);
		}

	}

	private static boolean isValidEmailAddress(String email) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(Constants.MAIL_VALIDATION_PATTERN);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	private static boolean isValidPassword(String password) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(Constants.PASSWORD_VALIDATION_PATTERN);
		java.util.regex.Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
