package com.example.cocinandoconjava.utils;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class HtmlSanitizer {
	public static String clean(String html) {
		return Jsoup.clean(html, Safelist.relaxed());
	}
}
