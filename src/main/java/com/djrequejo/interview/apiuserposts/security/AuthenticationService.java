package com.djrequejo.interview.apiuserposts.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "djrequejo";

    public static Authentication getAuthentication(HttpServletRequest request) {
        if (isPublicEndpoint(request)) {
            return null;
        }

        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }

    private static boolean isPublicEndpoint(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        if ((HttpMethod.GET.matches(method) && "/api/v1/users".equals(requestURI)) ||
            (HttpMethod.POST.matches(method) && "/api/v1/users".equals(requestURI))) {
            return true; 
        }

        return false; 
    }
}
