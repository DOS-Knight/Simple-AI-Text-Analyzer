package com.example.myapplication;

public class AnalysisModel {

    public String text;
    public String emotion;
    public String topic;
    public String keywords;
    public String summary;

    public AnalysisModel(String text, String emotion, String topic, String keywords, String summary) {
        this.text = text;
        this.emotion = emotion;
        this.topic = topic;
        this.keywords = keywords;
        this.summary = summary;
    }
}