package org.alex.text2speech.util.document2str;

import org.alex.text2speech.service.SpiderService;
import org.alex.text2speech.util.PropsUtil;
import org.alex.text2speech.util.spider.douluo.document2str.DouluoConverter;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DouluoConverterTest {
    private static String url;

    @Before
    public void init() {
        url = PropsUtil.getBookProperty("douluo1.url");
    }

//    @Test
//    public void document2Str() throws IOException {
//        int startPageIdx = 8585;
//        int startFileIdx = 1;
//
//        for (int pageIdx = startPageIdx, fileIdx = startFileIdx; pageIdx <= 10003; pageIdx += 2) {
//            String curRequestURL = url + pageIdx + ".html";
//
//            Document document = SpiderService.getDocumentFromUrl(curRequestURL);
//            String s = DouluoConverter.document2Str(document, curRequestURL);
//
//            if (s.equals("skip")) {
//                continue;
//            }
//
//            String fileOutPutPath = PropsUtil.getBookProperty("file.output.path");
//            File outPutFile = new File(fileOutPutPath + fileIdx + ".txt");
//            FileUtils.touch(outPutFile);
//            FileUtils.write(outPutFile, s, StandardCharsets.UTF_8);
//
//            fileIdx++;
//        }
//    }
}