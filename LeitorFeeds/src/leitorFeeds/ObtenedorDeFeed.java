package leitorFeeds;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObtenedorDeFeed {

	public ObtenedorDeFeed(String enderecoFeed, Feed feed)
		throws MalformedURLException, IOException{
		obterConteudoFeed(enderecoFeed, feed);
	}

	private void obterConteudoFeed(String enderecoFeed, Feed feed)
			throws MalformedURLException, IOException {
		URL url = new URL(enderecoFeed);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String linha;
		String texto = "";

		while ((linha = reader.readLine()) != null) {
			texto = texto.concat("\n" + linha);
		}
		//System.out.println(texto.length());
		feed.setConteudoFeed(texto);
		reader.close();
	}
	

}
