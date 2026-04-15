package com.kucw.security.security;

import jakarta.servlet.*;

import java.io.IOException;

// implements Filter from jakarta.servlet.Filter
public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("MyFilter1");

        // call next filter
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
