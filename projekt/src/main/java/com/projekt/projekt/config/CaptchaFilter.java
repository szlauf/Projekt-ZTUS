package com.projekt.projekt.config;

import java.io.IOException;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CaptchaFilter extends OncePerRequestFilter {

    private final String recaptchaSecretKey;
    private final RestTemplate restTemplate;

    public CaptchaFilter(String recaptchaSecretKey) {
        this.recaptchaSecretKey = recaptchaSecretKey;
        this.restTemplate = new RestTemplate();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if ("POST".equals(request.getMethod()) && "/process-login".equals(request.getRequestURI())) {
            String recaptchaResponse = request.getParameter("g-recaptcha-response");
            String remoteIp = request.getRemoteAddr();
            String url = "https://www.google.com/recaptcha/api/siteverify?secret=" +
                    recaptchaSecretKey + "&response=" + recaptchaResponse + "&remoteip=" + remoteIp;

            GoogleRecaptchaResponse recaptchaApiResponse = restTemplate.postForObject(url, null, GoogleRecaptchaResponse.class);

            if (recaptchaApiResponse == null || !recaptchaApiResponse.isSuccess()) {
                response.sendRedirect("/login?captchaError=true");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
