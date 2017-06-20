package com.aricent.cop.webengers.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.aricent.cop.webengers.common.ApiAiGlobals;

public class ApiAiHelper {
	public static URI createQuery(String message, String sessionId) throws UnsupportedEncodingException {
		UriComponents urlConponents = UriComponentsBuilder.newInstance()
				                                          .scheme(ApiAiGlobals.PROTOCOL)
				                                          .host(ApiAiGlobals.HOSTNAME)
				                                          .path(ApiAiGlobals.CONTEXT_PATH)
				                                          .queryParam(ApiAiGlobals.VERSION_KEY, ApiAiGlobals.DEFAULT_VERSION)
				                                          .queryParam(ApiAiGlobals.LANGUAGE_KEY, "en")
				                                          .queryParam(ApiAiGlobals.SESSIONID_KEY, (StringUtils.isEmpty(sessionId) ? ApiAiGlobals.DEFAULT_SESSIONID : sessionId))
				                                          .queryParam(ApiAiGlobals.QUERY_KEY, message)
				                                          .build()
				                                          .encode();
		
		return urlConponents.toUri();
	}
}
