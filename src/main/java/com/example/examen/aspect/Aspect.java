package com.example.examen.aspect;


import com.example.examen.repository.projetRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {
  projetRepo projetRepo;
    Logger logger = (Logger) LoggerFactory.getLogger(Aspect.class);
    @After(" execution(* com.example.examen.service..*(..)) ")

    public void logMethodexittt(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After(" execution(* com.example.examen.service..*(..)) ")
    public void logMethodExitt(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After(" execution(* com.example.examen.service..*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(" Out of method " + name + " : ");
    }

}
