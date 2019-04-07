package cn.itdeer.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.filter
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/7/18:04
 */

@Component
@WebFilter(urlPatterns = "/*", filterName = "time5Filter")
@Order(5)
public class Time5Filter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter5 init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入Filter5 ...");

        long start = new Date().getTime();

        chain.doFilter(request,response);

        System.out.println("耗时5：" + (new Date().getTime() - start));
    }

    @Override
    public void destroy() {
        System.out.println("Filter5 destroy ...");
    }
}
