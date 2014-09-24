/**
 * 
 */
package com.tweet.core;

import java.util.List;

/**
 * @author mmc
 *
 */
public class DataTwitterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<MyTweet> myTweets = DataTwitter.getTweetByHashtag("tunisie");
		
		for(MyTweet mt : myTweets){
			System.out.println(mt);
		}

	}

}
