package leitorFeeds;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import leitorFeeds.Feed.Item;

public class AnalisadorFeed extends DefaultHandler {
	private String url;
	private Feed feed;
	private StringBuilder texto;
	private Item item;
	private boolean statusImagem;

	public AnalisadorFeed(String url) {
		this.url = url;
		this.texto = new StringBuilder();
	}

	public void analisar() throws MalformedURLException, IOException,
	ParserConfigurationException, SAXException {
		InputStream urlInputStream = null;
		SAXParserFactory spf = null;
		SAXParser sp = null;

		urlInputStream = new ObtenedorDeFeed(url).obterFeed();
		spf = SAXParserFactory.newInstance();
		if (spf != null) {
			sp = spf.newSAXParser();
			sp.parse(urlInputStream, this);
		}

		if (urlInputStream != null)
			urlInputStream.close();
	}

	public Feed obterFeed() {
		return (feed);
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {
		if (qName.equalsIgnoreCase("channel"))
			feed = new Feed();
		else if (qName.equalsIgnoreCase("item") && (feed != null)) {
			item = new Item();
			feed.adicionarItem(item);
		} else if (qName.equalsIgnoreCase("image") && (feed != null))
			statusImagem = true;
	}

	public void endElement(String uri, String localName, String qName) {
		if (feed == null)
			return;

		if (qName.equalsIgnoreCase("item"))
			item = null;

		else if (qName.equalsIgnoreCase("image"))
			statusImagem = false;

		else if (qName.equalsIgnoreCase("title")) {
			if (item != null)
				item.setTitle(texto.toString().trim());
			else if (statusImagem)
				feed.setImageTitle(texto.toString().trim());
			else
				feed.configurarTitulo(texto.toString().trim());
		}

		else if (qName.equalsIgnoreCase("link")) {
			if (item != null)
				item.setLink(texto.toString().trim());
			else if (statusImagem)
				feed.setImageLink(texto.toString().trim());
			else
				feed.setLink(texto.toString().trim());
		}

		else if (qName.equalsIgnoreCase("description")) {
			if (item != null)
				item.setDescription(texto.toString().trim());
			else
				feed.setDescription(texto.toString().trim());
		}

		else if (qName.equalsIgnoreCase("url") && statusImagem)
			feed.setImageUrl(texto.toString().trim());

		else if (qName.equalsIgnoreCase("language"))
			feed.setLanguage(texto.toString().trim());

		else if (qName.equalsIgnoreCase("generator"))
			feed.setGenerator(texto.toString().trim());

		else if (qName.equalsIgnoreCase("copyright"))
			feed.setCopyright(texto.toString().trim());

		else if (qName.equalsIgnoreCase("pubDate") && (item != null))
			item.setPubDate(texto.toString().trim());

		else if (qName.equalsIgnoreCase("category") && (item != null))
			feed.adicionarItem(texto.toString().trim(), item);

		texto.setLength(0);
	}

	public void characters(char[] ch, int start, int length) {
		texto.append(ch, start, length);
	}
}
