package com.explore.gateway.filter.pre;

import com.explore.gateway.constant.EnumIgnoreAuthPath;
import com.explore.gateway.constant.JwtProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 拦截过程
 * first: 首先请求会通过security 这个地方会进行判断这个请求是否需要验证
 * second:如果需要验证 这个请求用户是否有权限
 * third:没有权限返回没有权限的页面或者无权码
 * forth:跳转登录认证服务 auth-server
 *      1.认证登录的过程
 *      2.返回token
 * fifth:前置过滤器获取是否有token，有token就解析放到zuul的上下文里面
 * sixth:继续第一步的流程
 *
 * security验证完毕之后才会进入这个filter..
 * 这个时候在做附加的配置和判断等等
 *
 * @Author stanley.yu
 * @Date 2019/1/31 16:23
 */
@Slf4j
public class FirstPreFilter extends ZuulFilter implements Filter {

    @Autowired
    private AntPathMatcher antPathMatcher;

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        log.info("is crossing first filter...");
        boolean shouldFilter = true;
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        EnumIgnoreAuthPath[] values = EnumIgnoreAuthPath.values();
        for (EnumIgnoreAuthPath value : values) {
            String ignorePath = value.getDesc();
            if (antPathMatcher.match(ignorePath,request.getRequestURI())){
                shouldFilter = false;
                log.info("pass url --> {}",request.getRequestURI());
                break;
            }
        }

        return shouldFilter;
    }

    /**
     * zuul filter
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request =ctx.getRequest();
        String header = request.getHeader(jwtProperties.getHeader());
        ctx.addZuulRequestHeader(jwtProperties.getHeader(),header);
        return null;
    }

    /**
     * java base Filter
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("java base filter crossing...");
    }
}
