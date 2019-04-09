package cn.itdeer.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.interceptor
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/9/12:32
 */

@Component
public class TimeInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long startTime = new Date().getTime();
        request.setAttribute("startTime",startTime);

        HandlerMethod hm = (HandlerMethod)handler;

        System.out.println("Interceptor1 preHandle 进入");
        System.out.println("执行的类为：" + hm.getBean().getClass().getName());
        System.out.println("执行的方法为：" + hm.getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long startTime = (long)request.getAttribute("startTime");
        System.out.println("Interceptor1 postHandle 耗时：" + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor1 afterCompletion");
        long startTime = (long)request.getAttribute("startTime");
        System.out.println("Interceptor1 afterCompletion 耗时：" + (new Date().getTime() - startTime));
        System.out.println("ex:" + ex);

    }
}
