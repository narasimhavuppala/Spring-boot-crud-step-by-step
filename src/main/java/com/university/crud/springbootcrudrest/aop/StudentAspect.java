package com.university.crud.springbootcrudrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
	@Before(value = "execution(* com.university.crud.springbootcrudrest.service.StudentService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());

		//System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	@After(value = "execution(* com.university.crud.springbootcrudrest.service.StudentService.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());

		//System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
}
