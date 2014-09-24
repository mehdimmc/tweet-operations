/**
 * 
 */
package com.tweet.core;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import twitter4j.Status;

/**
 * @author Mehdi
 *
 */
@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
@ToString
public class MyTweet {

	private Long id;  
	private String content; 
	private String hashtage;
	private String location;
	private double latitude;
	private double longitude;
	private Date timeTweet;
	private int retweet;
	private int nbRetweet;
	private int nbFavoris;
	private UtilisateurTwitter user;
	/**
	 * 
	 */
	public MyTweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param content
	 * @param hashtage
	 * @param location
	 * @param timeTweet
	 * @param user
	 */
	public MyTweet(Long id, String content, String hashtage, String location,
			Date timeTweet,int retweet, UtilisateurTwitter user) {
		super();
		this.id = id;
		this.content = content;
		this.hashtage = hashtage;
		this.location = location;
		this.timeTweet = timeTweet;
		this.setRetweet(retweet);
		this.user = user;
	}
	
	public MyTweet(Status s){
		int retweet = 0;
		
		if (s.getText().startsWith("RT"))
			retweet = 1;
		
		String hashtag = "";
		try{
			if (s.getText().contains("#")) {
				String[] listString = s.getText().split("#");
				for (int i = 0; i < listString.length; i++) {
					hashtag += "#" + listString[i].split(" ")[0] + " ";
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			hashtag = "";
		}
		
		
		double latitude = 0;
		double longitude= 0;
		if(s.getGeoLocation() != null){
			latitude = s.getGeoLocation().getLatitude();
			longitude = s.getGeoLocation().getLongitude();
		}
		
		this.setId(s.getId());
		this.setContent(s.getText().replace("'", " "));
		this.setHashtage(hashtag);
		this.setLocation(s.getUser().getLocation());
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setTimeTweet(s.getCreatedAt());
		this.setRetweet(retweet);
		this.setNbRetweet(s.getRetweetCount());
		this.setNbFavoris(s.getFavoriteCount());
	
	}
	
		

}
