package com.springboot.local.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.local.domain.AuthzEmpData;
import com.springboot.local.services.AuthzServices;

//https://dzone.com/articles/aspect-oriented-programming-with-springboot

@Aspect
@Component
public class LogAuthzReaponseValues {
	@AfterReturning(value="execution(* com.springboot.local.services.*.*Public(*))",
			        returning= "authzEmpData")
	public void logResponseValue(JoinPoint jp, AuthzEmpData authzEmpData){
	  System.out.println("==@AfterReturning====> "+jp.getTarget());
	  System.out.println("==@AfterReturning====> "+authzEmpData.getId());
	}
	
	@AfterReturning(value="execution(* com.springboot.local.services.*.*Private(*))",
	        returning= "authzEmpData")
public void logResponseValuePrivate(JoinPoint jp, AuthzEmpData authzEmpData){
System.out.println("==@AfterReturning====> "+jp.getTarget());
System.out.println("==@AfterReturning====> "+authzEmpData.getId());
}
	
/*	@Before("execution(* com.springboot.local.services.AuthzServices.authorize(String name))"
	        && target(authorize) && args(name))
public void logResponseValueBefore(AuthzServices authorize, String name){
System.out.println("==@Before name====> "+name);
}*/

}
