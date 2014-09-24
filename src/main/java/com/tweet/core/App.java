/**
 * 
 */
package com.tweet.core;

import java.util.Scanner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


public class App {
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws TwitterException
	 */
	public static void main(String[] args) throws TwitterException {

		// The TwitterFactory object provides an instance of a Twitter object
		// via the getInstance() method. The Twitter object is the API consumer.
		// It has the methods for interacting with the Twitter API.
		TwitterFactory tf = new TwitterFactory();
		Twitter twitter = tf.getInstance();

		boolean keepItGoinFullSteam = true;
		do {
			// Main menu
			Scanner input = new Scanner(System.in);
			System.out.print("\n--------------------"
					+ "\nH. Home Timeline\nS. Search\nT. Tweet"
					+ "\n--------------------"
					+ "\nA. Get Access Token\nQ. Quit"
					+ "\n--------------------\n> ");
			String choice = input.nextLine();

			try {

				// Home Timeline
				if (choice.equalsIgnoreCase("H")) {

					// Display the user's screen name.
					User user = twitter.verifyCredentials();
					System.out.println("\n@" + user.getScreenName()
							+ "'s timeline:");

					// Display recent tweets from the Home Timeline.
					for (Status status : twitter.getHomeTimeline()) {
						System.out.println("\n@"
								+ status.getUser().getScreenName() + ": "
								+ status.getText());
					}

				}

				// Search
				else if (choice.equalsIgnoreCase("S")) {

					// Ask the user for a search string.
					System.out.print("\nSearch: ");
					String searchStr = input.nextLine();

					// Create a Query object.
					Query query = new Query(searchStr);

					// Send API request to execute a search with the given
					// query.
					QueryResult result = twitter.search(query);

					// Display search results.
					for (Status status : result.getTweets()) {
						System.out.println("\n@" + status.getUser().getName()
								+ ": " + status.getText());
					}

				}

				// Tweet
				else if (choice.equalsIgnoreCase("T")) {

					boolean isOkayLength = true;
					String tweet;
					do {
						// Ask the user for a tweet.
						System.out.print("\nTweet: ");
						tweet = input.nextLine();

						// Ensure the tweet length is okay.
						if (tweet.length() > 140) {
							System.out.println("Too long! Keep it under 140.");
							isOkayLength = false;
						}
					} while (isOkayLength == false);

					// Send API request to create a new tweet.
					Status status = twitter.updateStatus(tweet);
					System.out.println("Just tweeted: \"" + status.getText()
							+ "\"");

				}

				// Get Access Token
				else if (choice.equalsIgnoreCase("A")) {

					// First, we ask Twitter for a request token.
					RequestToken reqToken = twitter.getOAuthRequestToken();
					System.out.println("\nRequest token: "
							+ reqToken.getToken() + "\nRequest token secret: "
							+ reqToken.getTokenSecret());

					AccessToken accessToken = null;
					while (accessToken == null) {

						// The authorization URL sends the request token to
						// Twitter in order
						// to request an access token. At this point, Twitter
						// asks the user
						// to authorize the request. If the user authorizes,
						// then Twitter
						// provides a PIN.
						System.out
								.print("\nOpen this URL in a browser: "
										+ "\n    "
										+ reqToken.getAuthorizationURL()
										+ "\n"
										+ "\nAuthorize the app, then enter the PIN here: ");
						String pin = input.nextLine();
						try {
							// We use the provided PIN to get the access token.
							// The access
							// token allows this app to access the user's
							// account without
							// knowing his/her password.
							accessToken = twitter.getOAuthAccessToken(reqToken,
									pin);
						} catch (TwitterException te) {
							System.out.println(te.getMessage());
						}
					}
					System.out.println("\nAccess token: "
							+ accessToken.getToken()
							+ "\nAccess token secret: "
							+ accessToken.getTokenSecret() + "\nSuccess!");

				}

				// Quit
				else if (choice.equalsIgnoreCase("Q")) {

					keepItGoinFullSteam = false;

				}

				// Bad choice
				else {

					System.out.println("Invalid option.");
				}

			} catch (IllegalStateException ise) {
				System.out.println(ise.getMessage());
			}

		} while (keepItGoinFullSteam == true);
	}
}
