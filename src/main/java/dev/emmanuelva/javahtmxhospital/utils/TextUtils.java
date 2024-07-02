package dev.emmanuelva.javahtmxhospital.utils;

import java.text.Normalizer;

public class TextUtils {
    public static String normalizeText(String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();
    }
}
