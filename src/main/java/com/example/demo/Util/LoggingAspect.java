package com.example.demo.Util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void logControllerMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String arguments = getArgumentsAsPrettyString(joinPoint.getArgs());

        logger.info("\n====== Controller Method Entry ======\n" +
                        "Method      : {}\n" +
                        "Parameters  : {}\n" +
                        "=====================================",
                methodName, arguments);
    }

    @AfterReturning(value = "execution(* com.example.demo.controller.*.*(..)) && !@annotation(org.springframework.web.bind.annotation.GetMapping)",
            returning = "result")
    public void logControllerMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        logger.info("\n====== Controller Method Exit ======\n" +
                        "Method      : {}\n" +
                        "Return Value: {}\n" +
                        "=====================================",
                methodName, result);
    }

    private String getArgumentsAsPrettyString(Object[] args) {
        if (args == null || args.length == 0) {
            return "No arguments";
        }
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            sb.append("  arg").append(i + 1).append(": ")
                    .append(arg != null ? arg.toString() : "null")
                    .append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
