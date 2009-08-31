package leitorFeeds;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class LeitorFeed {
	private Feed feed;

	public LeitorFeed(String url) throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException {
		AnalisadorFeed af = new AnalisadorFeed(url);

		af.analisar();
		feed = af.obterFeed();
	}

	public Feed obterFeed() {
		return feed.clone();
	}
}