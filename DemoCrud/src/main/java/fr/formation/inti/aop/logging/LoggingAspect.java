package fr.formation.inti.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	   
	

	@Before("execution(* fr.formation.inti.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.debug("Method called:" + joinPoint.getSignature().getName());
		
		
	}
	
	@After("execution(* fr.formation.inti.controller.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		logger.debug("Method finished:" + joinPoint.getSignature().getName());
	}

	/**
	 * Right error on logger
	 * @param ex
	 */
	@AfterThrowing(pointcut = "execution(* fr.formation.inti.controller..* (..))", throwing = "ex")
	public void errorInterceptor(Exception ex) {
	    if (logger.isDebugEnabled()) {
	        logger.debug("Error Message Interceptor started");
	    }
	    // DO SOMETHING HERE WITH EX
	    logger.debug( ex.getCause().getMessage());

	    if (logger.isDebugEnabled()) {
	        logger.debug("Error Message Interceptor finished.");
	    }
	}
}
