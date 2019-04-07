package cn.itdeer.filter.config;

import cn.itdeer.filter.Time1Filter;
import cn.itdeer.filter.Time2Filter;
import cn.itdeer.filter.Time3Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * PackageName : cn.itdeer.filter.config
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/7/18:11
 */

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean time1Filter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        Time1Filter time1Filter = new Time1Filter();

        filterRegistrationBean.setFilter(time1Filter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");

        filterRegistrationBean.setUrlPatterns(urls);

        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;

    }


    @Bean
    public FilterRegistrationBean time2Filter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        Time2Filter time2Filter = new Time2Filter();

        filterRegistrationBean.setFilter(time2Filter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");

        filterRegistrationBean.setUrlPatterns(urls);

        filterRegistrationBean.setOrder(2);

        return filterRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean time3Filter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        Time3Filter time3Filter = new Time3Filter();

        filterRegistrationBean.setFilter(time3Filter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");

        filterRegistrationBean.setUrlPatterns(urls);

        filterRegistrationBean.setOrder(3);

        return filterRegistrationBean;

    }


}
