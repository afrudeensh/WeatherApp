package com.example.utils;

import java.util.Arrays;
import java.util.List;

public class NewsApiDefaults {
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String DEFAULT_COUNTRY = "us";

    public static final List<String> SUPPORTED_LANGUAGES = Arrays.asList(
            "ar", "de", "en", "es", "fr", "he", "it", "nl", "no",
            "pt", "ru", "sv", "ud", "zh"
    );

    public static final List<String> SUPPORTED_COUNTRIES = Arrays.asList(
            "ae", "ar", "at", "au", "be", "bg", "br", "ca", "ch", "cn", "co", "cu", "cz",
            "de", "eg", "fr", "gb", "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp",
            "kr", "lt", "lv", "ma", "mx", "my", "ng", "nl", "no", "nz", "ph", "pl", "pt",
            "ro", "rs", "ru", "sa", "se", "sg", "si", "sk", "th", "tr", "tw", "ua", "us",
            "ve", "za"
    );
    public static boolean isValidLanguage(String language) {
        return SUPPORTED_LANGUAGES.contains(language);
    }

    public static boolean isValidCountry(String country) {
        return SUPPORTED_COUNTRIES.contains(country);
    }
}
