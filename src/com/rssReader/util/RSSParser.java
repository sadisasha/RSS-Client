package com.rssReader.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * Created by Unuservize on 13.11.2014.
 */
public class RSSParser {

	public RSSParser(InputStream input) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {

			InputStream xmlInput = input;
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new SaxHandler();
			saxParser.parse(xmlInput, handler);

		} catch (Throwable err) {
			err.printStackTrace();
		}
	}
}


class SaxHandler extends DefaultHandler {

	private boolean getTitle = false;
	private boolean getDate  = false;
	private boolean getText  = false;

	public void startDocument() throws SAXException {
		//System.out.println("start document   : ");
	}

	public void endDocument() throws SAXException {
		//System.out.println("end document   : ");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("start element    : " + qName);
		if ("title".equals(qName)) {
			getTitle = true;
		}
		if ("pubDate".equals(qName)) {
			getDate = true;
		}
		if ("description".equals(qName)) {
			getText = true;
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("end element      : " + qName);
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (getTitle) {
			String title = new String(ch, start, length);
			if (!"Java для начинающих".equals(title)) {
				System.out.println("Title : " + title);
			}
			getTitle = false;
		}

		if (getDate) {
			String date = new String(ch, start, length);
			System.out.println("Date : " + date);

			getDate = false;
		}

		if (getText) {
			String text = new String(ch, start, length);

			if (!"Изучаем java программирование".equals(text)) {
				System.out.println("Text : " + new String(ch, start, length));
			}

			getText = false;
		}

		//System.out.println("start characters : " +
		//        new String(ch, start, length));
	}

	public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
	}

}
