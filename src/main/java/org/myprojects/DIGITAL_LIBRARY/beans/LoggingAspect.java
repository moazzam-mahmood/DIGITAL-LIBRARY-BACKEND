package org.myprojects.DIGITAL_LIBRARY.beans;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Log before method execution
    @Before("execution(* org.myprojects.DIGITAL_LIBRARY.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("➡️ Entering: {}.{}() with arguments = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    // Log after method returns
    @AfterReturning(pointcut = "execution(* org.myprojects.DIGITAL_LIBRARY.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("✅ Exiting: {}.{}() with result = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result);
    }

    // Log on exceptions
    @AfterThrowing(pointcut = "execution(* org.myprojects.DIGITAL_LIBRARY.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("❌ Exception in {}.{}() with cause = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getCause() != null ? ex.getCause() : "NULL");
    }

    // Measure execution time
    @Around("execution(* org.myprojects.DIGITAL_LIBRARY.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();  // execute actual method
        long duration = System.currentTimeMillis() - start;

        log.info("⏱ {}.{}() executed in {} ms",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                duration);

        return proceed;
    }
}
