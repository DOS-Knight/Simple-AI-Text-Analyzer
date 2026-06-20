package com.example.myapplication;

import java.util.LinkedHashSet;

public class KeywordExtractor {

    public static String extract(String text) {

        String[] words = text.split(" ");

        LinkedHashSet<String> keywords = new LinkedHashSet<>();

        for (String w : words) {

            if (w.length() > 3) {
                keywords.add(w);
            }
        }

        if (keywords.isEmpty())
            return "کلمه کلیدی ای یافت نشد";

        return String.join("، ", keywords);
    }
}