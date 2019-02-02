package com.explore.gateway.config;

import com.explore.gateway.filter.pre.FirstPreFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import javax.servlet.Filter;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/1/31 16:38
 */
@Configuration
public class BeanBaseFactory {

    @Bean
    public AntPathMatcher initMatcher(){
        return new AntPathMatcher();
    }

    @Bean
    public Filter AccessFilter(){
        return new FirstPreFilter();//自定义的过滤器
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean1(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(AccessFilter());
        filterRegistrationBean.addUrlPatterns("/");
        filterRegistrationBean.setOrder(5);//order的数值越小 则优先级越高
        return filterRegistrationBean;
    }
}
