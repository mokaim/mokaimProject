package io.github.mokaim.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Before("execution(* io.github.mokaim.controller..*.*(..) )")
    public void initLog(){
        log.info("AOP에서 컨트롤러 메소드가 실행되었습니다. !!!");
    }
}
