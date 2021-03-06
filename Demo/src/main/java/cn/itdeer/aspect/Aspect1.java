package cn.itdeer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.aspect
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/10/17:17
 */

//@Aspect
@Component
public class Aspect1 {

    @Around("execution(* cn.itdeer.web.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = new Date().getTime();


        System.out.println("进入Aspect1...");

        Object[] objects = pjp.getArgs();
        for (Object obj: objects) {
            System.out.println("Obj:" + obj);
        }

        Object o = pjp.proceed();

        System.out.println("Aspect1 耗时：" + (new Date().getTime() - startTime));

        return o;
    }

}
