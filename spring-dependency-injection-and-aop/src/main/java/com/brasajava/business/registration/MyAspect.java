package com.brasajava.business.registration;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	public MyAspect(){}
		
	
	@Pointcut(value="execution(** com.brasajava.business.registration.Bean.theMethod())")
	//@Pointcut(value="execution(** com.brasajava..*(..))")
	public void theMethod(){}
	
	
	@Before(value="theMethod()")
	public void before(){
		System.out.println("Before - Method");
	}
	
	@After(value="theMethod()")
	public void after(){
		System.out.println("After Method"); 
	}

}
