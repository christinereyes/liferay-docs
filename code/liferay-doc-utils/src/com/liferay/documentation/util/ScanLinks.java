package com.liferay.documentation.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class ScanLinks {

	public static void main(String[] args) throws IOException, ParserException {

		System.out.println("Checking for broken links ...");
		System.out.println("This will take several minutes ...");
		
		String docDir = args[0];
		
		String[] dirTypes = {"", "-dxp"};

		for (String dirType : dirTypes) {
			        
			File articleDir = new File("../" + docDir + "/articles" + dirType);
			
			File[] articleDirFiles = articleDir.listFiles();
			List<File> articles = new ArrayList<File>();

			Queue<File> q = new LinkedList<File>();
			for (File f : articleDirFiles) {
				q.add(f);
			}

			while (!q.isEmpty()) {
				File f = q.remove(); 

				if (f.isDirectory()) {
					File[] files = f.listFiles();

					for (File file : files) {
						q.add(file);
					}
				}
				else {
					if (f.getName().endsWith(".markdown")) {
						articles.add(f);
					}
				}
			}

			for (File mkdFile : articles) {

				if (!mkdFile.getName().endsWith(".markdown")) {
					continue;
				}

				LineNumberReader in = new LineNumberReader(new FileReader(
						mkdFile));
				String line = null;

				while ((line = in.readLine()) != null) {
					
					if (!line.contains("localhost")) {
						if (line.contains("](/develop/") || line.contains("](/discover/") ||
								line.contains("](/distribute/")) {
							//ldnUrls.add(extractLdnUrl(line, in.getLineNumber()));
							String ldnUrl = extractLdnUrl(line, in.getLineNumber());
							checkLdnUrl(ldnUrl, mkdFile.getName());
						}
						else if (line.contains("](www.") || line.contains("](http")) {
							String url = extractRegularUrl(line, in.getLineNumber());
							checkUrl(url, mkdFile.getName());
						}
					}
				}
				in.close();
			}
		}

	}
	
	private static void checkLdnUrl(String url, String fileName)
			throws ParserException {
		
		Parser htmlParser = new Parser(url);
		List<String> results = new LinkedList<String>();
		NodeList list = htmlParser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
		
		for (int i = 0; i < list.size(); i++) {
			
			final LinkTag link = (LinkTag) list.elementAt(i);
            final String linkString = link.getLink();
            results.add(linkString);
        }
		
		for (String x : results) {
			if (x.contains("2Fsearch&#x25;2Fsearch&#x26;_3_redirect&#x3d;")) {
				System.out.println(fileName + " --- ARTICLE " + ldnArticle + " DNE");
				break;
			}
			else {
				continue;
			}
		}
	}
	
	private static void checkUrl(String url, String fileName) {
		
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection(); 
			huc.setRequestMethod("GET");
			huc.connect();
		} catch (IOException e) {
			System.out.println(fileName + " --- URL " + url + " DNE");
		}
	}
	
	private static String extractLdnUrl(String line, int lineNumber) {
		
			int begIndex = line.indexOf("](/") + 2;
			int endIndex = line.indexOf(")", begIndex);
			String endLdnUrl = null;
			
			try{
				endLdnUrl = line.substring(begIndex, endIndex);
			} catch (StringIndexOutOfBoundsException e) {
				endLdnUrl = line.substring(begIndex, line.length());
				System.out.println("Relative path on line " + lineNumber + " has incorrect link ending");
			}
			
			ldnArticle = endLdnUrl;
			
			String begLdnUrl = "https://dev.liferay.com";

			String ldnUrl = begLdnUrl.concat(endLdnUrl);

			return ldnUrl;
	}

	private static String extractRegularUrl(String line, int lineNumber) {

		
		int begIndex = line.indexOf("](") + 2;
		int endIndex = line.indexOf(")", begIndex);
		String url = null;

		try {
			url = line.substring(begIndex, endIndex);
		} catch (StringIndexOutOfBoundsException e) {
			url = line.substring(begIndex, line.length());
			System.out.println("URL on line " + lineNumber + " has incorrect link ending");
		}
		
		return url;
	}

	private static String ldnArticle;

}
