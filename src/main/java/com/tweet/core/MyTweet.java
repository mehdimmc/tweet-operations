/**
 * 
 */
package com.tweet.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mehdi
 *
 */
public class MyTweet {

	private Long Id;  
	private String Content; 
	private String Hashtage;
	private String location;
	private double latitude;
	private double longitude;
	private Date timeTweet;
	private int retweet;
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
		Id = id;
		Content = content;
		Hashtage = hashtage;
		this.location = location;
		this.timeTweet = timeTweet;
		this.setRetweet(retweet);
		this.user = user;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}
	/**
	 * @return the hashtage
	 */
	public String getHashtage() {
		return Hashtage;
	}
	/**
	 * @param hashtage the hashtage to set
	 */
	public void setHashtage(String hashtage) {
		Hashtage = hashtage;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the timeTweet
	 */
	public Date getTimeTweet() {
		return timeTweet;
	}
	/**
	 * @param timeTweet the timeTweet to set
	 */
	public void setTimeTweet(Date timeTweet) {
		this.timeTweet = timeTweet;
	}
	/**
	 * @return the user
	 */
	public UtilisateurTwitter getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UtilisateurTwitter user) {
		this.user = user;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Hashtage == null) ? 0 : Hashtage.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MyTweet)) {
			return false;
		}
		MyTweet other = (MyTweet) obj;
		if (Hashtage == null) {
			if (other.Hashtage != null) {
				return false;
			}
		} else if (!Hashtage.equals(other.Hashtage)) {
			return false;
		}
		if (Id != other.Id) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyTweet [Id=" + Id + ", Content=" + Content + ", Hashtage="
				+ Hashtage + ", location=" + location + ", timeTweet="
				+ timeTweet + ", user=" + user + "]";
	}
	public int getRetweet() {
		return retweet;
	}
	public void setRetweet(int retweet) {
		this.retweet = retweet;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	

}
