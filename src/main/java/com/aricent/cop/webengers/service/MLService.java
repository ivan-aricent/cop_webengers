package com.aricent.cop.webengers.service;

import com.aricent.cop.webengers.models.MessageResponse;

public interface MLService {

	public MessageResponse processMessage(String message, String sessionId);

}
