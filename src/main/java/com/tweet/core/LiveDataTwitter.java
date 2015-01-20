/**
 * 
 */
package com.tweet.core;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author mmc
 *
 */
public class LiveDataTwitter {

	public static ArrayList<Status> execute(final String hashtag,ConfigurationBuilder cb)
			throws TwitterException, InterruptedException {
		// skipped for brevity...

		final BlockingQueue<Status> statuses = new LinkedBlockingQueue<Status>(20);
		TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

		StatusListener handlerTweet = new StatusListener() {
			
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onStatus(Status status) {
				statuses.offer(status);
				
			}
			
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
				
			}
		};

//			@Override
//			public void onStatus(Status status) {
//				long diff = c.getTimeInMillis()	- Calendar.getInstance().getTimeInMillis();
//				long diffDate = Math.abs(diff);
//				long nbSeconde = diffDate / 3600;
//				
//				
//				System.out.println("tweet : "+ status.getText());				    
//				statuses.offer(new StatusUtil(true, status));
//				
//				if (nbSeconde > 10) {
//					for(int i = 0 ; i < 20; i++){
//						statuses.offer(new StatusUtil(false, null));	
//					}									
//				}
//			}

		FilterQuery fq = new FilterQuery();
		final String keywords[] = {hashtag};
		fq.track(keywords);
		
		twitterStream.addListener(handlerTweet);
		twitterStream.filter(fq);
		
		// Collect the 1000 statues
		final ArrayList<Status> collected = new ArrayList<Status>(20);
//		System.out.println("collection size : " + collected.size());
//		while (collected.size() < TOTAL_TWEETS || nbSeconde < 10) {
//
//			final StatusUtil status = statuses.poll(20, TimeUnit.SECONDS);
//
//			if (status == null) {
//				continue;
//			}
//
//			collected.add(status);
//			diff = c.getTimeInMillis()- Calendar.getInstance().getTimeInMillis();
//			diffDate = Math.abs(diff);
//			nbSeconde = diffDate / 3600;
//
//		}	
//		twitterStream.shutdown();
		return collected;
	}
}
