package org.alex.text2speech.util.spider.douluo.document2str;

import lombok.extern.java.Log;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

@Log
public final class DouluoConverter {

    public static String document2Str(Document document, String urlStr) {
        Elements titleElement = document.getElementsByTag("h1");
        String title = titleElement.get(0).text();

        if (!title.matches("第.*章.*")) {
            log.info("Unmatched title" + title + "\nURL: " + urlStr);
            return "skip";
        }

        Elements contentDiv = document.getElementsByClass("ui-tabs-panel");

        StringBuilder resBuilder = new StringBuilder();
        resBuilder.append(title).append("\n");
        String regexp = "<p>|</p>|&nbsp;|（未完待续）";

        for (Node curNode : contentDiv.get(0).childNodes()) {
            String replacedParagraph = curNode.toString().replaceAll(regexp, "");
            resBuilder.append(replacedParagraph);
        }

        return resBuilder.toString();
    }
}
