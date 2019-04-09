package cn.itdeer.interceptor.config;


import cn.itdeer.interceptor.TimeInterceptor1;
import cn.itdeer.interceptor.TimeInterceptor2;
import cn.itdeer.interceptor.TimeInterceptor3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description :
 * PackageName : cn.itdeer.interceptor.config
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/9/12:52
 */
@Configuration(value = "interceptorConfig")
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor1 timeInterceptor1;
    @Autowired
    private TimeInterceptor2 timeInterceptor2;
    @Autowired
    private TimeInterceptor3 timeInterceptor3;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor1).excludePathPatterns("/*");
        registry.addInterceptor(timeInterceptor2).excludePathPatterns("/*");
        registry.addInterceptor(timeInterceptor3).excludePathPatterns("/*");
    }
}
