package org.alex.text2speech.util.spider.douluo.document2str;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.service.SpiderService;
import org.alex.text2speech.util.PropsUtil;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Douluo1Spider {
    public static void execute(String savePath) {
        System.out.println("正在将文件保存在\"" + savePath + "\"目录下");

        int startPageIdx = 8585;
        int startFileIdx = 1;
        String url = PropsUtil.getBookProperty("douluo1.url");

        for (int pageIdx = startPageIdx, fileIdx = startFileIdx; pageIdx <= 10003; pageIdx += 2, fileIdx++) {
            String curRequestURL = url + pageIdx + ".html";

            Document document;
            try {
                document = SpiderService.getDocumentFromUrl(curRequestURL);
            } catch (MalformedURLException e) {
                log.warning("处理小说URL时出现错误");
                return;
            }
            String s = DouluoConverter.document2Str(document, curRequestURL);

            if (s.equals("skip")) {
                continue;
            }

            File outPutFile = new File(savePath + fileIdx + ".txt");
            try {
                FileUtils.touch(outPutFile);
                FileUtils.write(outPutFile, s, StandardCharsets.UTF_8);
            } catch (IOException e) {
                log.warning("保存小说文件时出错");
            }
        }
    }
}
