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
    // Konstruktor klasy CaptchaFilter, przyjmuje klucz tajny reCAPTCHA
    public CaptchaFilter(String recaptchaSecretKey) {
        this.recaptchaSecretKey = recaptchaSecretKey;
        this.restTemplate = new RestTemplate();
    }
    // Metoda doFilterInternal, dziedziczona z OncePerRequestFilter, odpowiedzialna za realizację filtra
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Sprawdzenie, czy żądanie jest typu POST i dotyczy ścieżki "/process-login"
        if ("POST".equals(request.getMethod()) && "/process-login".equals(request.getRequestURI())) {
            
            // Pobranie wartości reCAPTCHA z parametru żądania
            String recaptchaResponse = request.getParameter("g-recaptcha-response");

            // Pobranie adresu IP klienta
            String remoteIp = request.getRemoteAddr();
            
            // Budowanie URL do weryfikacji reCAPTCHA na podstawie klucza tajnego, odpowiedzi reCAPTCHA i adresu IP klienta
            String url = "https://www.google.com/recaptcha/api/siteverify?secret=" +
                    recaptchaSecretKey + "&response=" + recaptchaResponse + "&remoteip=" + remoteIp;

            // Wywołanie zewnętrznego serwisu reCAPTCHA za pomocą RestTemplate     
            GoogleRecaptchaResponse recaptchaApiResponse = restTemplate.postForObject(url, null, GoogleRecaptchaResponse.class);

            // Sprawdzenie odpowiedzi od reCAPTCHA
            if (recaptchaApiResponse == null || !recaptchaApiResponse.isSuccess()) {
                // Przekierowanie na stronę logowania z informacją o błędzie weryfikacji reCAPTCHA
                response.sendRedirect("/login?captchaError=true");
                return;
            }
        }

        // Kontynuacja łańcucha filtrowania, jeżeli nie zachodzi warunek weryfikacji reCAPTCHA
        filterChain.doFilter(request, response);
    }
}
