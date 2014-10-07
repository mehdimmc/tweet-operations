/**
 * 
 */
package com.tweet.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.tweet.core.domain.MyTweet;
import com.tweet.core.domain.UserTwitter;

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
	public static Set<ConfigurationBuilder> getListConfig() {
		
		// TODO : add correct param for connecting
		String consumerKey = "";
		String consumerSecret = "";
		String accessToken = "";
		String accessSecret = "";
		
		listConf.add(getConf(consumerKey, consumerSecret, accessToken, accessSecret));
		
		// if you want to add another user configurated,
		// you can add them here,
		// you have just to copy and past the same code
		return listConf;
	}

	public static ConfigurationBuilder getConf(String consumerKey,String consumerSecret,String accessToken,String accessSecret) {
        
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
				.setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken)
				.setOAuthAccessTokenSecret(accessSecret);

		return cb;
	}
	
	public static List<MyTweet> getTweetByHashtag(String hashtag,Integer maxTweet,ConfigurationBuilder cfg){
		try{
			
			int i = 0;			
			List<MyTweet> myTweets = new ArrayList<MyTweet>();
			
			TwitterFactory tf = null;
			Twitter twitter = null;
			Query query = null;
			long lastID = Long.MAX_VALUE;
			
			
			tf = new TwitterFactory(cfg.build());
			twitter = tf.getInstance();
			query = new Query(hashtag);
    	    query.setCount(100);
    	    
    	    while ( maxTweet - i != 0) {
    	    	
    	    	if (maxTweet - i > 100){
    	    		query.setCount(100);
    	    	}else{
    	    		query.setCount(maxTweet - i);
    	    	}
    	    	
    	    	QueryResult result = twitter.search(query);
    	    	
    	    	for (Status s : result.getTweets()) {
        	    	
            		UserTwitter u = new UserTwitter(s.getUser().getScreenName(), s.getUser().getId(), new Long(s.getUser().getFollowersCount()), new Long(s.getUser().getFriendsCount()));
            	
            		MyTweet t = new MyTweet(s);
            		t.setUser(u);
            		myTweets.add(t);
            		
            		// for passing a limit of getting just 100 tweet every execute 
            		if(s.getId() < lastID){
            			lastID = t.getId();
            			query.setMaxId(lastID);
            		}
            		
            		i++;
        	    }
	    	    	
            		
            		
	    	    	
	    	   
	    	    
	    	    return myTweets;
				
			}
		}catch(TwitterException e){
			if(e.getErrorCode() == 88){
				System.out.println("Limit Twitter exceeded");
			}else{
				System.out.println("Identifiant entered are incorrect");
			}
			//e.printStackTrace();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return new ArrayList<MyTweet>();
	}
	
	public static List<MyTweet> getTweetFromUser(String username,Integer maxTweet,ConfigurationBuilder cfg){
		try{
			
			int i = 0;
			
			List<MyTweet> myTweets = new ArrayList<MyTweet>();
			
			TwitterFactory tf = null;
			Twitter twitter = null;
			Query query = null;
			long lastID = Long.MAX_VALUE;
			
			
			tf = new TwitterFactory(cfg.build());
			twitter = tf.getInstance();
			query = new Query("from:"+username);
    	   
    	    
    	    while ( maxTweet - i != 0) {
    	    	
    	    	if (maxTweet - i > 100){
    	    		query.setCount(100);
    	    	}else{
    	    		query.setCount(maxTweet - i);
    	    	}
    	    	
    	    	QueryResult result = twitter.search(query);
    	    	
    	    	for (Status s : result.getTweets()) {
        	    	
            		UserTwitter u = new UserTwitter(s.getUser().getScreenName(), s.getUser().getId(), new Long(s.getUser().getFollowersCount()), new Long(s.getUser().getFriendsCount()));
            	
            		MyTweet t = new MyTweet(s);
            		t.setUser(u);
            		myTweets.add(t);
            		
            		// for passing a limit of getting just 100 tweet every execute 
            		if(s.getId() < lastID){
            			lastID = t.getId();
            			query.setMaxId(lastID);
            		}
            		
            		i++;
        	    }
	    	    	
    	    }   
	    	   		
			return myTweets;		
		}catch(TwitterException e){
			if(e.getErrorCode() == 88){
				System.out.println("Limit Twitter exceeded");
			}else{
				System.out.println("Identifiant entered are incorrect");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return new ArrayList<MyTweet>();
	}

}
