package org.alex.text2speech.service;

import org.alex.text2speech.util.azure.Text2SpeechUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

public class Text2SpeechUtilTest {
    public static String[] customerVoiceNameArr = {"zh-CN-XiaoxiaoNeural", "zh-CN-YunyangNeural"};

    @Test
    /*
      测试批量处理文件夹内所有txt文件的功能
     */
    public void batchConvertFile2Wav() {
        String directoryPath = "/Users/alex/Desktop/demo1/";
        String outputPath = directoryPath;

        Text2SpeechUtil.batchConvertFile2Wav(directoryPath, outputPath, customerVoiceNameArr[1]);
    }

    @Test
    /*
      测试处理单个text文件的功能
     */
    public void convertFile2Wav() {
        String directoryPath = "/Users/alex/Desktop/demo1/";
        String file = directoryPath + "/demo1/1.txt";

        Text2SpeechUtil.convertFile2Wav(file, directoryPath + "1.mp3", customerVoiceNameArr[1]);
    }

    @Test
    /*
      测试处理字符的功能
     */
    public void convertStr2Wav() {
        String directoryName = "/Users/alex/Desktop/demo1/";
        Text2SpeechUtil.convertStr2Wav("我是中国人，我爱我的祖国，祖国啊，祖国！", directoryName + "demo.mp3", customerVoiceNameArr[0]);
    }

    @Test
    /*
      测试用户自定义音频格式和码率的功能
     */
    public void convertStr2WavWithCustomerAudioFormat() {
    }

    @Test
    public void demo() {
        String directoryPath = "/Users/alex/Desktop/demo1/";
        Collection<File> files = FileUtils.listFiles(new File(directoryPath), null, true);
        for (File curFile : files) {
            System.out.println(curFile.getAbsoluteFile());
            System.out.println(curFile.getName());

            System.out.println(curFile.getParent());
        }
    }
}