package com.microservices.demo.twitter.to.kafka.service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.StatusAdapter;

@Component
public class TwitterKafkaStatusListener extends StatusAdapter{
	
	private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStatusListener.class);
	
	@Override
	public void onStatus(Status status) {
		LOG.info("Twitter status with text {}", status.getText());
	};

//	public static void main(String[] args) throws TwitterException, IOException{
//	    StatusListener listener = new StatusListener(){
//	        public void onStatus(Status status) {
//	            System.out.println(status.getUser().getName() + " : " + status.getText());
//	        }
//	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
//	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
//	        public void onException(Exception ex) {
//	            ex.printStackTrace();
//	        }
//	    };
//	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
//	    twitterStream.addListener(listener);
//	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
//	    twitterStream.sample();
//	}
}
