package com.kucw.security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// 確保 Filter 只執行一次
public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("MyFilter2");

        String url = request.getRequestURI();

        if(url.equals("/hello")){
            System.out.println("Hello 允許通過！");
            filterChain.doFilter(request, response);
        } else {
            System.out.println("其他請求被拒絕！");
            response.setStatus(500);
        }
    }
}
