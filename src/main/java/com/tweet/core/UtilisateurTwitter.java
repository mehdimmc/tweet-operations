package com.tweet.core;

import java.io.Serializable;

public class UtilisateurTwitter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId ;
	private String userName = "test" ;
	private Long nbreFollower = new Long(0) ;
	private Long nbreFollowing = new Long(0);
	
	/**
	 * 
	 */
	public UtilisateurTwitter() {
		super();		
	}
	/**
	 * @param userName
	 * @param userId
	 */
	public UtilisateurTwitter(String userName, Long userId) {
		super();
		this.userName = userName;
		this.userId = userId;
	}
	/**
	 * @param userName
	 * @param userId
	 * @param nbrFollowers
	 * @param nbrFollowing 
	 */
	public UtilisateurTwitter(String userName, Long userId,Long nbrFollowers,Long nbrFollowing) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.nbreFollower = nbrFollowers;
		this.nbreFollowing = nbrFollowing;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (!(obj instanceof UtilisateurTwitter)) {
			return false;
		}
		UtilisateurTwitter other = (UtilisateurTwitter) obj;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}
	/**
	 * @return the nbreFollower
	 */
	public Long getNbreFollower() {
		return nbreFollower;
	}
	/**
	 * @param nbreFollower the nbreFollower to set
	 */
	public void setNbreFollower(Long nbreFollower) {
		this.nbreFollower = nbreFollower;
	}
	/**
	 * @return the nbreFollowing
	 */
	public Long getNbreFollowing() {
		return nbreFollowing;
	}
	/**
	 * @param nbreFollowing the nbreFollowing to set
	 */
	public void setNbreFollowing(Long nbreFollowing) {
		this.nbreFollowing = nbreFollowing;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UtilisateurTwitter [userId=" + userId + ", userName="
				+ userName + ", nbreFollower=" + nbreFollower
				+ ", nbreFollowing=" + nbreFollowing + "]";
	}
	
	
	
	

}
