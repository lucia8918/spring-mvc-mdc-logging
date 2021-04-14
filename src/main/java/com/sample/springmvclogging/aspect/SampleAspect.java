package com.sample.springmvclogging.aspect;

import com.sample.springmvclogging.constant.LogConstant;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SampleAspect {

  @Pointcut("execution(* com.sample.springmvclogging.application.controller.*.*(..) )")
  public void controllerAdvice() {
  }

  @Before("controllerAdvice()")
  public void requestLogging(JoinPoint joinPoint) {

    // MDC Tracing id Setting
    MDC.put(LogConstant.TRACING_ID, UUID.randomUUID().toString());

    // Logging REQUEST Info's,,,,
    log.info("REQUEST ::: TRACING_ID ::: {}", MDC.get(LogConstant.TRACING_ID));
  }

  @AfterReturning(pointcut = "controllerAdvice()", returning = "returnValue")
  public void requestLogging(JoinPoint joinPoint, Object returnValue) {

    // Logging RESPONSE Info's,,,,
    log.info("RESPONSE ::: RESULT ::: {}", returnValue);

    // MDC Clear
    MDC.clear();
  }
}
