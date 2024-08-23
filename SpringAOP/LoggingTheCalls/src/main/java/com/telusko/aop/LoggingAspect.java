package com.telusko.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingAspect {
	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	// No method is called now. We cannot see the output method called in console.
	public void logMethodCall() {
		LOGGER.info("Method Called");
	}
}
