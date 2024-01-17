package com.projekt.projekt.Utils;

import java.util.Base64;

public class ImageUtils {

    // Metoda do kodowania tablicy bajtów do formatu Base64
    public static String encodeByteArrayToBase64(byte[] byteArray) {

        // Uzyskanie instancji klasy Base64.Encoder za pomocą metody getEncoder()
        // Następnie wywołanie metody encodeToString(byteArray), która koduje tablicę bajtów do formatu Base64
        return Base64.getEncoder().encodeToString(byteArray);
    }
}
