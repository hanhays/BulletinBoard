package com.naver.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAdvice {
	
	@Before("execution(* com.naver.service.TestService*.*(..))")
	public void start() {
	}
	
	@After("execution(* com.naver.service.TestService*.*(..))")
	public void end(JoinPoint jp) {
		Object[] args = jp.getArgs();
	}
	
	@Around("execution(* com.naver.service.TestService*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis();
		return obj;
		
	}


}
