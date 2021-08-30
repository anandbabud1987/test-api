package com.anand.filter;


import org.springframework.web.util.UriBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

import static com.anand.constants.WebConstants.PASSWORD;
import static com.anand.constants.WebConstants.USERNAME;

public class AuthFilter extends HttpFilter {


    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String authHeader = servletRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            servletResponse.setStatus(401);
            return;
        }
        String[] token = authHeader.split(" ");
        if (token != null && token.length == 2 && !isValidToken(token[1])) {
            servletResponse.setStatus(401);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isValidToken(String s) {
        byte[] decoded = Base64.getDecoder().decode(s);
        String decodedString = new String(decoded);
        String actualBasic = USERNAME + ":" + PASSWORD;
        return actualBasic.equals(decodedString);
    }
}
