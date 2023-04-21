package com.zjt.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect // 表明此类为一个切面
@Component
public class UserAspect {

    /**
     * 定义pointcut 切面的前置通知
     * 在执行目标方法之前执行的方法就叫前置通知
     */
    @Before("pointcut()")
    public void doBefore() {
        System.out.println("执行前置通知");
    }

    /**
     * 切点，也就是规则，满足什么情况就进行拦截（Aspect J 表达式语法）
     * 拦截该包下的UserController类的所有方法
     * 最前面的 * 表示拦截所有返回类型的方法
     * 最后面的 (..) 表示拦截所有类型的参数
     * */
    @Pointcut("execution(* com.zjt.aop.controller.UserController.*(..))")
    public void pointcut() {
        // 规则制定者，可以不写方法体，有那个规则就行了
    }

    /**
     * 在return那一刻执行，比后置通知更早执行
     */
    @AfterReturning("pointcut()")
    public void doAfterReturning() {
        System.out.println("执行返回之后通知");
    }

    /**
     * 出现异常后通知的方法
     */
    @AfterThrowing("pointcut()")
    public void doAfterThrowing() {
        System.out.println("执行异常后通知");
    }

    /**
     * 执行了目标方法之后的方法就叫后置通知
     */
    @After("pointcut()")
    public void doAfter() {
        System.out.println("执行后置通知");
    }

    /**
     * 环绕通知：包围了整个程序执行的过程
     * 并且查看每个方法执行所需的时间
     */
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        Object obj = null;
        // System.out.println("环绕通知：前置方法");
        try {
            stopWatch.start(); //统计方法的执行时间，开始计时

            obj = joinPoint.proceed(); // 也就是执行目标方法，以及对应的通知

            stopWatch.stop(); // 停止计时
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // System.out.println("环绕通知：后置方法");

        // 查看每个方法的执行所需时间
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "方法执行花费的时间：" +
                stopWatch.getTotalTimeMillis() + "ms");
        return obj;
    }

}
