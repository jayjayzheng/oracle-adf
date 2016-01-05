package com.jayjay.view;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.controller.ControllerContext;
import oracle.adf.share.ADFContext;

public class ApplicationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException,
                                                         ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;

        String pageByReq = (String)req.getAttribute("Page");
        System.out.println("page is by req.getAttribute = " + pageByReq);

        ADFContext adfc = ADFContext.getCurrent();
        String page = (String)adfc.getRequestScope().get("Page");

        System.out.println("page is : " + page);


        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
