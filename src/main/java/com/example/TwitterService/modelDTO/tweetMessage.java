package com.example.TwitterService.modelDTO;

public class tweetMessage {
    public tweetMessage(String text) {
        this.text = text;
    }
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
