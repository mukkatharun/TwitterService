package com.example.TwitterService.modelDTO;

import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;


public class tweetDTO {
    public tweetDTO(String id, String text, Date createdAt) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
    }

    private String id;
    private String text;
    private Date createdAt;

    public String getTweet() {
        return text;
    }

    public void setTweet(String tweet) {
        this.text = tweet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
