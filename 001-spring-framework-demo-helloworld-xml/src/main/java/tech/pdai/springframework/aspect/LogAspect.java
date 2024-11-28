package tech.pdai.springframework.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author pdai
 */
@Aspect
public class LogAspect {

    /**
     * aspect for every methods under service package.
     */
    @Around("execution(* tech.pdai.springframework.service.*.*(..))")
    //定义一个环绕通知，拦截tech.pdai.springframework.service包下的所有方法。
    public Object businessService(ProceedingJoinPoint pjp) throws Throwable {
        // get attribute through annotation
        //定义一个环绕通知方法，参数ProceedingJoinPoint用于访问被拦截的方法。
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        System.out.println("execute method: " + method.getName());

        // continue to process
        //return pjp.proceed()：继续执行被拦截的方法，并返回其结果。
        Object result=pjp.proceed();

        System.out.println("方法执行完毕");
        return result;
    }

}
