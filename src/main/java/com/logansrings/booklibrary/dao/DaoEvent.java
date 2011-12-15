package com.logansrings.booklibrary.dao;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DaoEvent {
	
	@Pointcut(
			"execution(* com.logansrings.booklibrary.dao.*.save(..))")
	private void saveMarkerMethod() {}
	
	@After(value="saveMarkerMethod()")
	public void saved() {
		System.out.println("something saved");
	}

	public void savedUsingAround(ProceedingJoinPoint joinPoint) {
		System.out.println("before something saved");
		try {
			joinPoint.proceed();
			System.out.println("after something saved");
		} catch (Throwable e) {
			e.printStackTrace();
		}		
	}

}
