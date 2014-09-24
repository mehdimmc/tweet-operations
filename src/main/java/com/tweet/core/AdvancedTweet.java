package com.tweet.core;

/**
 * 
 * @author Bizid Imen
 *
 */
public class AdvancedTweet {

	private String id;
	private String username;
	private String content;
	private String type;
	private String posted_time;
	private String friends;
	private String followers;
	private String latitude;
	private String longitude;
	
	/**
	 * 
	 */
	public AdvancedTweet() {
		super();	
	}
	/**
	 * 
	 * @param id
	 * @param username
	 * @param content
	 * @param type
	 * @param posted_time
	 * @param friends
	 * @param followers
	 * @param latitude
	 * @param longitude
	 */
	public AdvancedTweet(String id, String username, String content,
			String type, String posted_time, String friends, String followers,
			String latitude, String longitude) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
		this.type = type;
		this.posted_time = posted_time;
		this.friends = friends;
		this.followers = followers;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the posted_time
	 */
	public String getPosted_time() {
		return posted_time;
	}
	/**
	 * @param posted_time the posted_time to set
	 */
	public void setPosted_time(String posted_time) {
		this.posted_time = posted_time;
	}
	/**
	 * @return the friends
	 */
	public String getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(String friends) {
		this.friends = friends;
	}
	/**
	 * @return the followers
	 */
	public String getFollowers() {
		return followers;
	}
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(String followers) {
		this.followers = followers;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((followers == null) ? 0 : followers.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result
				+ ((posted_time == null) ? 0 : posted_time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		if (!(obj instanceof AdvancedTweet)) {
			return false;
		}
		AdvancedTweet other = (AdvancedTweet) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (followers == null) {
			if (other.followers != null) {
				return false;
			}
		} else if (!followers.equals(other.followers)) {
			return false;
		}
		if (friends == null) {
			if (other.friends != null) {
				return false;
			}
		} else if (!friends.equals(other.friends)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (latitude == null) {
			if (other.latitude != null) {
				return false;
			}
		} else if (!latitude.equals(other.latitude)) {
			return false;
		}
		if (longitude == null) {
			if (other.longitude != null) {
				return false;
			}
		} else if (!longitude.equals(other.longitude)) {
			return false;
		}
		if (posted_time == null) {
			if (other.posted_time != null) {
				return false;
			}
		} else if (!posted_time.equals(other.posted_time)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
}

