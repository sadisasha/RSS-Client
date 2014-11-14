package com.rssReader.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Unuservize on 13.11.2014.
 */
public class RSSXMLRequest {

	private String xmlFile;
	private String uri;

	RSSXMLRequest(String _uri) {
		uri = _uri;
		xmlFile = "";
	}

	public String getXMLFile() {
		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");

			InputStream xmlFileStream = connection.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(xmlFileStream));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}

			xmlFile = out.toString();

			return xmlFile;
		} catch (IOException e) {
			e.getStackTrace();
			return "Error getting xmlFile";
		}
	}

}