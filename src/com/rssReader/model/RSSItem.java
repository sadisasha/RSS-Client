package com.rssReader.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** @author sobolevstp */
public class RSSItem {

	private final StringProperty title;
	private final StringProperty date;
	private final StringProperty text;

	public RSSItem() {
		this(null, null, null);
	}

	public RSSItem(String title, String date, String text) {
		this.title = new SimpleStringProperty(title);
		this.date = new SimpleStringProperty(date);
		this.text = new SimpleStringProperty(text);
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public StringProperty titleProperty() {
		return title;
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public StringProperty dateProperty() {
		return date;
	}

	public String getText() {
		return text.get();
	}

	public void setText(String text) {
		this.text.set(text);
	}

	public StringProperty textProperty() {
		return text;
	}

}
