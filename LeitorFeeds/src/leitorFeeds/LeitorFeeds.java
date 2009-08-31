package leitorFeeds;

import java.io.IOException;
import java.net.MalformedURLException;

public class LeitorFeeds {
	static Feed feed;
	static ObtenedorDeFeed of;
	
	public static void main (String[] args){
		feed = new Feed();
		
		try {
			of = new ObtenedorDeFeed("http://feeds.feedburner.com/meiobit", feed);
		} catch (MalformedURLException e) {
			System.out.println("URL malformada...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problema de IO...");
			e.printStackTrace();
		}
		System.out.println(feed.getConteudoFeed());
	}
}