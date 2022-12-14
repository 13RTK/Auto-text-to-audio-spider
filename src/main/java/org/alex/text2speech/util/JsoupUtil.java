package org.alex.text2speech.util;

import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Log
public final class JsoupUtil {
    public static Document getDocumentFromUrl(String urlStr) throws MalformedURLException {
        Document res = null;
        URL url = new URL(urlStr);

        try {
            res = Jsoup.parse(url, 3000);
        } catch (IOException e) {
            log.warning("第一次请求失败，URL : " + urlStr +
                    "\n正在进行第二次请求....");
            try {
                res = Jsoup.parse(url, 3000);
            } catch (IOException ex) {
                log.warning("第二次请求失败，URL : " + urlStr +
                        "\n正在进行第三次请求....");
                try {
                    res = Jsoup.parse(url, 3000);
                } catch (IOException exc) {
                    log.warning("第三次请求失败，请求失败的URL : " + urlStr);
                }
            }
        }

        return res;
    }
}
