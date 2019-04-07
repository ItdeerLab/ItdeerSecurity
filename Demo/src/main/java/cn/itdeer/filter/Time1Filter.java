package cn.itdeer.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.filter
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/7/18:10
 */


public class Time1Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter1 init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入Filter1 ...");

        long start = new Date().getTime();

        chain.doFilter(request,response);

        System.out.println("耗时1：" + (new Date().getTime() - start));
    }

    @Override
    public void destroy() {
        System.out.println("Filter1 destroy ...");
    }
}
