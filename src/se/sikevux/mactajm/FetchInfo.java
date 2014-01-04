package se.sikevux.mactajm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;

class FetchInfo extends AsyncTask<String, Void, String[][]> {

	@Override
	protected String[][] doInBackground(String... params) {
		URL url;
		String returnValues[][] = new String[2][50];

		try {
			url = new URL(params[0]);
			Document document = Jsoup.parse(url, 5000);
			Element region = document.getElementById(params[1]);
			Elements links = region.getElementsByTag("a");
			int i = 0;
			for (Element link : links) {
				String linkHref = link.attr("href");
				String linkText = link.text();
				returnValues[0][i] = linkHref;
				returnValues[1][i] = linkText;
				i++;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnValues;
	}
}
