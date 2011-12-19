package com.logansrings.booklibrary.dao;

import org.aspectj.lang.JoinPoint;
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
	public void saved(JoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder()
		    .append("Saved ")
		    .append(joinPoint.getArgs()[0])
		    .append(" in ")
		    .append(joinPoint.getTarget())
		    .append(".")
		    .append(joinPoint.getSignature().getName())
		    .append(" ");
		System.out.println(sb.toString());
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
