package org.alex.text2speech.util.spider.douluo.document2str;

import lombok.extern.java.Log;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * DouluoConverter 是一个处理和转换 Douluo 类型文档的工具类。
 */
@Log
public final class DouluoConverter {

    /**
     * 将给定的 Document 对象转换为一个字符串，该字符串包含章节标题和内容。
     * 如果章节标题不匹配，则返回 "skip"。
     *
     * @param document Document 对象，包含章节标题和内容
     * @param urlStr   与文档关联的 URL 字符串
     * @return 一个字符串，包含章节标题和内容；如果章节标题不匹配，则返回 "skip"
     */
    public static String document2Str(Document document, String urlStr) {
        // 从 Document 中获取 h1 标签（包含章节标题）
        Elements titleElement = document.getElementsByTag("h1");
        String title = titleElement.get(0).text();

        // 检查章节标题是否符合预期的格式
        if (!title.matches("第.*章.*")) {
            log.info("Unmatched title" + title + "\nURL: " + urlStr);
            return "skip";
        }

        // 从 Document 中获取包含章节内容的 div
        Elements contentDiv = document.getElementsByClass("ui-tabs-panel");

        // 使用 StringBuilder 构建结果字符串
        StringBuilder resBuilder = new StringBuilder();
        resBuilder.append(title).append("\n");

        // 定义一个正则表达式，用于删除不需要的 HTML 标签和空格
        String regexp = "<p>|</p>|&nbsp;|（未完待续）";

        // 遍历 contentDiv 的子节点，并删除不需要的标签和空格
        for (Node curNode : contentDiv.get(0).childNodes()) {
            String replacedParagraph = curNode.toString().replaceAll(regexp, "");
            resBuilder.append(replacedParagraph);
        }

        return resBuilder.toString();
    }
}
