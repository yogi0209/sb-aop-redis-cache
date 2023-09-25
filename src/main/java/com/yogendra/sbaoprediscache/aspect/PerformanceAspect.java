package com.yogendra.sbaoprediscache.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class PerformanceAspect {
    private Logger logger = Logger.getLogger("performance");

    @Pointcut("@annotation(com.yogendra.sbaoprediscache.aspect.PerformanceLogger)")
    public void logExecutionTime() {

    }

    @Around("logExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            logger.info(proceedingJoinPoint.getSignature().toShortString() + " execution took " + executionTime + " milli seconds !!");
        }
    }
}
