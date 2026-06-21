package com.example.myapplication;

public class SummaryGenerator {

    public static String summarize(String text) {

        if (text.length() <= 50)
            return text;

        String shortText = text.substring(0, 50);

        return shortText + "... ( خلاصه شده متن )";
    }
}