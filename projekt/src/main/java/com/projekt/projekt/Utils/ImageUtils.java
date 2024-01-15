package com.projekt.projekt.Utils;

import java.util.Base64;

public class ImageUtils {

    public static String encodeByteArrayToBase64(byte[] byteArray) {
        return Base64.getEncoder().encodeToString(byteArray);
    }
}
