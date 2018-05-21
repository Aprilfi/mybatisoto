package com.yidu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {

    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("authfilter is run");
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        //1.获取请求URL
        String servletPath = httpRequest.getServletPath();

        //2.检测1中获取的servletPath是否为不需要检测的URl中的一个.若是,放行
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        if (urls.contains(servletPath)) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }

        //3.从session中获取SessionKey对应值,若值不存在,则重定向到redirectUrl
        Object user = httpRequest.getSession().getAttribute("username");
        if ((user == null)) {
            System.out.println("login error");
            httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
            return;
        }

        System.out.println("login success");
        //4.若存在,则放行
        filterChain.doFilter(httpRequest, httpResponse);

        /* 判断是否是登录页、首页、登录servlet
        if(servletPath.equals("/LoginServlet")) {
            // 是则直接转发到下一组件
            chain.doFilter(request, response);
        } else {
            // 否，则验证登录状态
            if (flag != null) {
                if (flag.equals("login_success")) {
                    // 登录成功，直接转发到下一组件
                    System.out.println("登录成功");
                    chain.doFilter(request, response);
                } else {
                    // 登录失败，跳转到登录页，并保证当前网页的url文件路径
                    System.out.println("登录失败");
                }
            }
        }*/
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("AuthFilter is init()");
        ServletContext servletContext = config.getServletContext();
        //获取XML文件中配置参数
        sessionKey = servletContext.getInitParameter("userSessionKey");
        System.out.println("sessionKey======" + sessionKey);
        redirectUrl = servletContext.getInitParameter("redirectPage");
        System.out.println("redirectPage======" + redirectUrl);
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
        System.out.println("uncheckedUrls=====" + uncheckedUrls);
    }

}
