package com.example.TwitterService;

import com.example.TwitterService.controllers.tweetContoller;
import com.example.TwitterService.modelDTO.tweetDTO;
import com.example.TwitterService.modelDTO.tweetMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(tweetContoller.class)
public class TwitterServiceApplicationTests extends AbstractTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	private tweetContoller contoller;

	@Test
	void getTweetsTest() throws Exception {
		String url = "/userTweets";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		tweetDTO[] productlist = super.mapFromJson(content, tweetDTO[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	void postTweetTest() throws Exception {
		String url = "/postTweets";
		tweetMessage tweetMessage = new tweetMessage("");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
						.contentType(MediaType.APPLICATION_JSON)
						.content(String.valueOf(tweetMessage))
						.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		tweetDTO[] productlist = super.mapFromJson(content, tweetDTO[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	void deleteTweetTest() throws Exception {
		String url = "/deleteTweet";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		assertTrue(content.equals("Successfully deleted"));
	}
}
