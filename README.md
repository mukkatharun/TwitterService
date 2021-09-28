# TwitterService

This is as part of Twitter Assignment for CMPE-272

I have created a RestApi services to implement the CURD operations with the tweets using the Twitter Developr's API

UserTweets - This have Get to fetch particular user tweets

PostTweet - for posting a tweet

deleteTweet - for deleting a particular tweet

Running the Backend:
1. Have Java 8 Installed in local
2. Install IntelliJ and Open the Repo, It Will install all the required dependencies required
3. Open the TwitterServiceApplication and run the main method
4. Once the the application started you can navigate to http://localhost:8080/

EndPoint details: Hit these endpoints in Postman
1. Get Tweets- 
  Get Call - http://localhost:8080/api/message/userTweets
2. Create Tweet
 POST call :  http://localhost:8080/api/message/postTweet
 Body: { "tweet": "Tweet Message here" } 
3. Delete Tweet
  POST Call - http://localhost:8080/api/message/deleteTweet?tweetId=1441846328586162178
  
  
  Running the TestCases:
  Go to the Test Folder, and run all the test cases in the TwitterServiceApplicationTests class to run all the test cases
