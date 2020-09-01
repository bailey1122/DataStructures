package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    private Map<String, String> urls = new HashMap<String, String>(),
            shortU = new HashMap<String, String>();

    public static String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (shortU.containsKey(longUrl))
            return BASE_HOST + shortU.get(longUrl);
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((int) Math.random() * chars.length());
            }
            key = sb.toString();
        } while (urls.containsKey(key));
        urls.put(key, longUrl);
        shortU.put(longUrl, key);

        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.get(shortUrl.replace(BASE_HOST, ""));
    }
}
