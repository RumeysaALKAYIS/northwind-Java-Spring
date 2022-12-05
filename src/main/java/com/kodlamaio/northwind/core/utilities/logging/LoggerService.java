package com.kodlamaio.northwind.core.utilities.logging;

import org.aspectj.lang.JoinPoint;

public interface LoggerService {

	void logBefore(JoinPoint joinPoint);
	void logAfter(JoinPoint joinPoint);
	void afterThrowing(JoinPoint joinPoint, Throwable throwable);
	void afterReturning(JoinPoint joinPoint);
}
