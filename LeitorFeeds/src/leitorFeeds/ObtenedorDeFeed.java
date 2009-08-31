package leitorFeeds;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ObtenedorDeFeed {
	private String url;
	
	public ObtenedorDeFeed(String url){
		this.url = url;
	}

	public InputStream obterFeed() throws IOException,
	MalformedURLException {
		URL url = new URL(this.url);
		return url.openConnection().getInputStream();
	}
}
