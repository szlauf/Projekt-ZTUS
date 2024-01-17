// Pakiet, w którym znajduje się klasa. Zwykle używany w celu zorganizowania kodu.
package com.projekt.projekt.config;
// Importowanie klas związanych z obsługą wyjątków i uwierzytelniania w Spring Security oraz servletów.
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// Klasa implementująca interfejs AuthenticationSuccessHandler w celu dostosowania zachowania po pomyślnym uwierzytelnieniu.
public class CustomAuthenticationSuccessHandler
    implements AuthenticationSuccessHandler {

  // Metoda wywoływana po pomyślnym uwierzytelnieniu użytkownika.    
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {
    // Przekierowanie użytkownika na stronę "/index" po pomyślnym uwierzytelnieniu.                                    
    response.sendRedirect("/index");
  }
}
