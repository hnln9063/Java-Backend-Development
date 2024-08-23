package com.telusko.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	// return type, fully qualified name, method name, arguments

	@Before("execution(* com.telusko.service.JobService.getJob (..)) || execution(* com.telusko.service.JobService.updateJob (..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called "+jp.getSignature().getName());
	}
}
