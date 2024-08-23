package com.telusko.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Before("execution(* com.telusko.service.JobService.* (..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called "+jp.getSignature().getName());
	}
	
	
	// After the execution of the methods getJob and updateJob
	// It is like a finally block
	@After("execution(* com.telusko.service.JobService.getJob (..)) || execution(* com.telusko.service.JobService.updateJob (..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed "+jp.getSignature().getName());
	}
	
	// Will get executed only if the exception is occurred
	// It is like a catch block
	@AfterThrowing("execution(* com.telusko.service.JobService.getJob (..)) || execution(* com.telusko.service.JobService.updateJob (..))")
	public void logMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method Executed "+jp.getSignature().getName());
	}
	
	// When there is no exception
	@AfterReturning("execution(* com.telusko.service.JobService.getJob (..)) || execution(* com.telusko.service.JobService.updateJob (..))")
	public void logMethodExecutedSuccess(JoinPoint jp) {
		LOGGER.info("Method Executed "+jp.getSignature().getName());
	}
}
