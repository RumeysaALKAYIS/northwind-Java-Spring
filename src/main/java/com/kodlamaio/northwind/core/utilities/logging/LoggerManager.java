package com.kodlamaio.northwind.core.utilities.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerManager implements LoggerService {
	
	Logger log = LoggerFactory.getLogger(LoggerManager.class);

	@Before("execution(* com.kodlamaio.northwind.wepApi.controllers.*.add(..))")
	@Override
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before: " + joinPoint.getSignature().getName() + " is starter!");

	}

	@After("execution(* com.kodlamaio.northwind.wepApi.controllers.*.update(..))")
	@Override
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After: " + joinPoint.getSignature().getName() + " is stop!");

	}

	@AfterThrowing(pointcut = "execution(* com.kodlamaio.northwind.wepApi.controllers.*.update(..))", throwing = "throwable")
	@Override
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		System.out.println("After Throwing: " + joinPoint.getSignature().getName() + " exaption handler!");
		System.out.println("Exception : " + throwable);

	}

	@AfterReturning("execution(* com.kodlamaio.northwind.wepApi.controllers.*.delete(..))")
	@Override
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("After Returning: " + joinPoint.getSignature().getName() + " delete is completed!");

	}

}
