package com.tweet.core.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author MMC
 *
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"userId"})
@ToString
public class UserTwitter implements Serializable{
	
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
	public UserTwitter() {
		super();		
	}
	/**
	 * @param userName
	 * @param userId
	 */
	public UserTwitter(String userName, Long userId) {
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
	public UserTwitter(String userName, Long userId,Long nbrFollowers,Long nbrFollowing) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.nbreFollower = nbrFollowers;
		this.nbreFollowing = nbrFollowing;
	}
	
	
}
