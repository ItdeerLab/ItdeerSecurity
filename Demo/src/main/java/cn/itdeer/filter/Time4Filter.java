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
@WebFilter(urlPatterns = "/*", filterName = "time4Filter")
@Order(4)
public class Time4Filter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter4 init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入Filter4 ...");

        long start = new Date().getTime();

        chain.doFilter(request,response);

        System.out.println("耗时4：" + (new Date().getTime() - start));
    }

    @Override
    public void destroy() {
        System.out.println("Filter4 destroy ...");
    }
}
