//package com.example.demo.config.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//@Slf4j
//public class AOPLogging {
//
//
//    @Around("within(com.example.demo.controllers.*))")
//    public void aroundLoggingController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        log.info("Start: " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
//        Object result = proceedingJoinPoint.proceed();
//        log.info("End: " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
//    }
//}
