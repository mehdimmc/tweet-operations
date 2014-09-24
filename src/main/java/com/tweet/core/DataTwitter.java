/**
 * 
 */
package com.tweet.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author mmc
 *
 */
public class DataTwitter {
	
	public static Set<ConfigurationBuilder> listConf = new HashSet<ConfigurationBuilder>();
	
	/**
	 * 
	 * @param it
	 * @return
	 */
	public static void getListConfig() {
		
		// TODO : add correct param for connecting
		String consumerKey = "";
		String consumerSecret = "";
		String accessToken = "";
		String accessSecret = "";

		listConf.add(getConf(consumerKey, consumerSecret, accessToken, accessSecret));
		
		// if you want to add another user configurated,
		// you can add them here,
		// you have just to copy and past the same code
		
	}

	public static ConfigurationBuilder getConf(String consumerKey,String consumerSecret,String accessToken,String accessSecret) {
        
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
				.setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken)
				.setOAuthAccessTokenSecret(accessSecret);

		return cb;
	}
	
	public static List<MyTweet> getTweetByHashtag(String hashtag){
		try{
			getListConfig();
			int i = 0;
			Iterator<ConfigurationBuilder> it = listConf.iterator();
			List<MyTweet> myTweets = new ArrayList<MyTweet>();
			
			TwitterFactory tf = null;
			Twitter twitter = null;
			Query query = null;
			long lastID = Long.MAX_VALUE;
			
			while(it.hasNext()){
				tf = new TwitterFactory(it.next().build());
				twitter = tf.getInstance();
				query = new Query(hashtag);
	    	    query.setCount(100);
	    	    
	    	    while (i < 1000) {
	    	    	
	    	    	if (1000 - i > 100){
	    	    		query.setCount(100);
	    	    	}else{
	    	    		query.setCount(1000 - i);
	    	    	}
	    	    	
	    	    	QueryResult result = twitter.search(query);
	    	    	
	    	    	for (Status s : result.getTweets()) {
	        	    	
	            		UtilisateurTwitter u = new UtilisateurTwitter(s.getUser().getScreenName(), s.getUser().getId(), new Long(s.getUser().getFollowersCount()), new Long(s.getUser().getFriendsCount()));
	            	
	            		MyTweet t = new MyTweet(s);
	            		t.setUser(u);
	            		myTweets.add(t);
	            	
	            		// for passing a limit of getting just 100 tweet every execute 
	            		if(s.getId() < lastID){
	            			lastID = t.getId();
	            		}
	            		query.setMaxId(lastID-1);
	        	    }
	    	    	
	    	    }
	    	    
	    	    return myTweets;
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return new ArrayList<MyTweet>();
	}

}
