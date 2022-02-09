package com.coderhouse.final_project.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectAfter {

    @After("execution(* com.coderhouse.final_project.controller.*.*(..))")
    void afterAdviceMethod() {
        log.info("After Aspect ejecutado. Request finalizado. ");
    }
}
