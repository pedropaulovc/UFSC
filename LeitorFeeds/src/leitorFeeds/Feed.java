package leitorFeeds;

import java.util.ArrayList;
import java.util.HashMap;

public class Feed {
	private String title;
	private String description;
	private String link;
	private String language;
	private String generator;
	private String copyright;
	private String imageUrl;
	private String imageTitle;
	private String imageLink;

	private ArrayList<Item> items;
	private HashMap<String, ArrayList<Item>> category;

	public void adicionarItem(Item item) {
		if (this.items == null)
			this.items = new ArrayList<Item>();
		this.items.add(item);
	}

	public void adicionarItem(String category, Item item) {
		if (this.category == null)
			this.category = new HashMap<String, ArrayList<Item>>();
		if (!this.category.containsKey(category))
			this.category.put(category, new ArrayList<Item>());
		this.category.get(category).add(item);
	}

	public Feed clone() {
		try {
			return (Feed) super.clone();
		} catch (Exception e) {
			return this;
		}
	}

	public void configurarTitulo(String title) {
		this.title = title;
	}

	public String obterTitulo() {
		return title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, ArrayList<Item>> getCategory() {
		return (HashMap<String, ArrayList<Item>>) category.clone();
	}

	public void setCategory(HashMap<String, ArrayList<Item>> category) {
		this.category = category;
	}

	public String obterTituloItem(int numItem){
		return items.get(numItem).getTitle();
	}
	
	public String obterDescricaoItem(int numItem){
		return items.get(numItem).getDescription();
	}
	
	public String obterLinkItem(int numItem){
		return items.get(numItem).getLink();
	}
	
	public String obterDataItem(int numItem){
		return items.get(numItem).getPubDate();
	}
	
	public int obterQtdItens(){
		return items.size();
	}
		
	public static class Item {
		private String title;
		private String description;
		private String link;
		private String pubDate;

		public String toString() {
			return (this.title + ": " + this.pubDate + "n" + this.description);
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getPubDate() {
			return pubDate;
		}

		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}
	}
}
