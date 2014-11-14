package com.rssReader.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static Logger log = LoggerFactory.getLogger(RSSXMLRequest.class);

	private String xmlFile;
	private String uri;

	public RSSXMLRequest(String uri) {
		this.uri = uri;
		this.xmlFile = "";
	}

	public String getXMLFile() {
		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			log.info("Connection established");
			log.info("Connection details: " + connection.toString());

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
			log.info("XML-file load is complete");
		} catch (IOException e) {
			e.getStackTrace();
			log.info("Error getting xmlFile");
		}

		return xmlFile;
	}

}