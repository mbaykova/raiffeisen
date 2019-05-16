package ru.aplana.demo.reporter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

@Aspect
public class AspectSteps {

    @Around("(@annotation(io.qameta.allure.Step) || @annotation(cucumber.api.java.en.When) || @annotation(cucumber.api.java.en.Then) " +
            "|| @annotation(cucumber.api.java.ru.Когда) || @annotation(cucumber.api.java.ru.Тогда)" +
            "|| @annotation(cucumber.api.java.ru.Дано)|| @annotation(cucumber.api.java.en.Given)" +
            "|| @annotation(cucumber.api.java.ru.И)|| @annotation(cucumber.api.java.en.And))" +
            " && execution(* *(..))")
    public Object step(final ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        AllureReporter.takeScreenshot("Скриншот шага " + methodSignature.getName() + "c параметрами :" + Arrays.toString(methodSignature.getParameterNames()));
        return joinPoint.proceed();
    }
}
