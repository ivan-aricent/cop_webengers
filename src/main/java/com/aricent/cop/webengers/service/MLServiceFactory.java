package com.aricent.cop.webengers.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MLServiceFactory {

	private Class concreateClass;
	private MLService instance;
	String className;

	public MLServiceFactory() {
		try {
			Properties prop = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream in = loader.getResourceAsStream("webengers.properties");
			prop.load(in);
			className = prop.getProperty("service.classname");
			if (StringUtils.isEmpty(className)) {
				className = "com.aricent.cop.webengers.service.ApiAiServiceImpl";
			}
			this.concreateClass = Class.forName(className);
			this.instance = (MLService) concreateClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MLService getMLService() {
		return instance;
	}
}
