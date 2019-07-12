package edu.mum.cs544.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs544.bank.logging.ILogger;

@Aspect
@Component
public class DaoLoggingAdvice {
	@Autowired
	private ILogger logger;
	
	public DaoLoggingAdvice(ILogger logger) {
		this.logger = logger;
	}

	@After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.log("Call was made to:" + joinpoint.getSignature().getName()
				+ " on " + joinpoint.getTarget().getClass());
	}
}
