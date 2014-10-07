/**
 * 
 */
package com.tweet.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import twitter4j.conf.ConfigurationBuilder;

import com.tweet.core.domain.MyTweet;

/**
 * @author mmc
 *
 */
public class DataTwitterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<ConfigurationBuilder> listConf = DataTwitter.getListConfig();
		Iterator<ConfigurationBuilder> it = listConf.iterator();
		List<MyTweet> myTweets = new ArrayList<MyTweet>();
		int j = 0;
		
		if(it.hasNext()){
			myTweets = DataTwitter.getTweetByHashtag("tunisie",100,it.next());
			
			for(MyTweet mt : myTweets){
				System.out.println(j+"- "+mt);
				j++;
			}
		}
		
		if(it.hasNext()){
			myTweets = DataTwitter.getTweetByHashtag("mmc_tunisia",20,it.next());
			j = 0;
			for(MyTweet mt : myTweets){
				System.out.println(j+"- "+mt);
				j++;
			}
		}

	}

}
