package com.softib.core.util;

import java.io.Serializable;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WebSocketUtil {

	public void pushNotification(String username, String message) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		MessageBean msg = new MessageBean();
		msg.setUsername(username);
		msg.setContent(message);
		String body;
		try {
			ObjectMapper OBJECT_MAPPER = createObjectMapper();
			body = OBJECT_MAPPER.writeValueAsString(msg);

			HttpEntity<String> request = new HttpEntity<String>(body, headers);
			restTemplate.postForEntity(Constants.PUSH_SERVER_URI, request, String.class);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	private ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}

}
