package com.demo.cardmanage.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.cardmanage.util.CollectionUtil;
import com.demo.cardmanage.util.StringUtil;



public class SimpleCorsFilter implements Filter {

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;// 是否允许http请求带上cookie等认证信息
    private String allowHeaders;
    private String exposeHeaders;
    private String maxAgent;

    /**
     * 不需要全局过滤的路径,正则表达式
     */
    private String excludedPagesReg;

    public String getAllowOrigin() {
        return allowOrigin;
    }

    public void setAllowOrigin(String allowOrigin) {
        this.allowOrigin = allowOrigin;
    }

    public String getAllowMethods() {
        return allowMethods;
    }

    public void setAllowMethods(String allowMethods) {
        this.allowMethods = allowMethods;
    }

    public String getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(String allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public String getAllowHeaders() {
        return allowHeaders;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public String getExposeHeaders() {
        return exposeHeaders;
    }

    public void setExposeHeaders(String exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
    }

    public String getMaxAgent() {
        return maxAgent;
    }

    public void setMaxAgent(String maxAgent) {
        this.maxAgent = maxAgent;
    }

    public String getExcludedPagesReg() {
        return excludedPagesReg;
    }

    public void setExcludedPagesReg(String excludedPagesReg) {
        this.excludedPagesReg = excludedPagesReg;
    }

    /**
     *
     * 过滤器主方法
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //根据配置信息设置响应头
        //设置允许访问的客户端域名
        if (!StringUtil.nullOrEmpty(allowOrigin)) {
            //如果为*则不进行限制
            if ("*".equals(allowOrigin)) {
                response.setHeader("Access-Control-Allow-Origin", "*");
            }else{
                //否则进行域名校验
                List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
                if (!CollectionUtil.nullOrEmpty(allowOriginList)) {
                    String currentOrigin = request.getHeader("Origin");
                    if (allowOriginList.contains(currentOrigin)) {
                        response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                    }
                }
            }
        }
        //允许访问的方法名，多个方法名用逗号分割
        if (!StringUtil.nullOrEmpty(allowMethods)) {
            response.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        //是否允许请求带有验证信息
        if (!StringUtil.nullOrEmpty(allowCredentials)) {
            response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        }
        //允许服务端访问的客户端请求头，多个请求头用逗号分割
        if (!StringUtil.nullOrEmpty(allowHeaders)) {
            response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        }
        //允许客户端访问的服务端响应头，多个响应头用逗号分割
        if (!StringUtil.nullOrEmpty(exposeHeaders)) {
            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        if (!StringUtil.nullOrEmpty(maxAgent)) {
            response.setHeader("Access-Control-Max-Age", maxAgent);
        }
        chain.doFilter(req, res);
    }

    /**
     *
     * 初始化filter配置参数
     */
    public void init(FilterConfig filterConfig) {
        if ( null == excludedPagesReg ) {
            excludedPagesReg = "";
        }
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param allowOrigin
     * @param allowMethods
     * @param allowCredentials
     * @param allowHeaders
     * @param exposeHeaders
     * @param maxAgent
     * @param excludedPagesReg
     */
    public SimpleCorsFilter(String allowOrigin, String allowMethods, String allowCredentials, String allowHeaders,
                            String exposeHeaders, String maxAgent, String excludedPagesReg) {
        super();
        this.allowOrigin = allowOrigin;
        this.allowMethods = allowMethods;
        this.allowCredentials = allowCredentials;
        this.allowHeaders = allowHeaders;
        this.exposeHeaders = exposeHeaders;
        this.maxAgent = maxAgent;
        this.excludedPagesReg = excludedPagesReg;
    }

    public void destroy() {}
}