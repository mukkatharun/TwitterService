package com.example.TwitterService.controllers;

import com.example.TwitterService.modelDTO.tweetDTO;
import com.example.TwitterService.services.instanceTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/message")
public class tweetContoller {

    @Autowired
    instanceTwitter instanceTwitter;
    
    @RequestMapping(value="/userTweets", method = RequestMethod.GET)
    public List<tweetDTO> getUserTweets() throws TwitterException {
        List<tweetDTO> tweets = new ArrayList<>();

        Twitter twitter =instanceTwitter.getTwitter();
        List<Status> statuses =twitter.getHomeTimeline();
        tweets = statuses.stream().map(t -> new tweetDTO(""+t.getId(), t.getText(), t.getCreatedAt())).collect(
                Collectors.toList());
        return tweets;
    }

    @RequestMapping(value="/postTweet", method = RequestMethod.POST)
    public String postTweet(@RequestBody tweetDTO tweetObject) throws TwitterException {
        String tweet = tweetObject.getTweet();
        Twitter twitter = instanceTwitter.getTwitter();

        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }

    @RequestMapping(value="/deleteTweet", method = RequestMethod.POST)
    public String deleteTweet(@RequestParam("tweetId") long tweetId) throws TwitterException {
        Twitter twitter = instanceTwitter.getTwitter();
        Status twe = twitter.showStatus(tweetId);
        twitter.destroyStatus(tweetId);
        return "Successfully Deleted";
    }

    @RequestMapping(value = "/helloWorld")
    public String sayHelloWorld() {
        return "Hello, World!!!";
    }
}
