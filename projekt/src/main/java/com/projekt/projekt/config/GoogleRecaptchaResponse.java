package com.projekt.projekt.config;

// Klasa GoogleRecaptchaResponse reprezentuje odpowiedź z serwera reCAPTCHA.

public class GoogleRecaptchaResponse {
    
    // Prywatne pola reprezentujące różne elementy odpowiedzi.
    private boolean success;    // Informacja o sukcesie weryfikacji.
    private String challengeTs; // Timestamp wyzwania reCAPTCHA.
    private String hostname;    // Nazwa hosta, który przesłał żądanie reCAPTCHA.

    // Metoda dostępu do pola success.
    public boolean isSuccess() {
        return success;
    }
    // Metoda ustawiająca wartość pola success.
    public void setSuccess(boolean success) {
        this.success = success;
    }
    // Metoda dostępu do pola challengeTs.
    public String getChallengeTs() {
        return challengeTs;
    }
    // Metoda ustawiająca wartość pola challengeTs.
    public void setChallengeTs(String challengeTs) {
        this.challengeTs = challengeTs;
    }
    // Metoda dostępu do pola hostname.
    public String getHostname() {
        return hostname;
    }
    // Metoda ustawiająca wartość pola hostname.
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    // Klasa ta pozwala na przechowywanie i manipulację informacjami zwróconymi przez serwer reCAPTCHA.
}
