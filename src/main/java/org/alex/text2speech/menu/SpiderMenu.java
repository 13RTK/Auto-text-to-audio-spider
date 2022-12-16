package org.alex.text2speech.menu;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.util.InputValidator;
import org.alex.text2speech.util.azure.Text2SpeechUtil;
import org.alex.text2speech.util.spider.douluo.document2str.Douluo1Spider;

import static org.alex.text2speech.menu.Menu.*;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpiderMenu {
    public static String textFileSavePath;
    public static final String SPIDER_PROCESS_STR = "正在爬取文件，请稍后...";

    public static void mainMenu() {
        String options = "1 : 《斗罗大陆1》\n" +
                BACK_MAIN_MENU_STR + EXIT_STR;

        System.out.println(MENU_COMPONENT_DELIMITER);
        System.out.println("请输入你需要爬取的小说对应的数字编号\n" + options);
        System.out.println(MENU_COMPONENT_DELIMITER);

        int inputNum = InputValidator.getValidateNumberFromInput(0, 1, options);
        switch (inputNum) {
            case 1:
                System.out.println("请输入文本文件保存的绝对路径: " + DIRECTORY_REMIND);
                textFileSavePath = scanner.nextLine();

                System.out.println(SPIDER_PROCESS_STR);
                Douluo1Spider.execute(textFileSavePath);
                break;
            case 7:
                Menu.mainMenu();
                break;
            case 0:
                exit();
                break;
            default:
                log.warning(ERROR_STR);
                exit();
        }

        operateAskAfterSpider();
    }

    private static void operateAskAfterSpider() {
        String options = "1 : 爬取其他图书\n" +
                "2 : 将爬取的文本转换为音频\n" +
                BACK_MAIN_MENU_STR + EXIT_STR;
        System.out.println(ASK_STR + options);

        int inputNum = InputValidator.getValidateNumberFromInput(0, 2, options);
        switch (inputNum) {
            case 1:
                mainMenu();
                break;
            case 2:
                log.info(Text2SpeechMenu.AUDIO_PROCESSING_STR);
                Text2SpeechUtil.batchConvertFile2Wav(textFileSavePath, textFileSavePath, Text2SpeechUtil.voiceName);
                System.out.println("转换完成, 请在对应的路径中查看: " + textFileSavePath + "\n");
                break;
            case 7:
                Menu.mainMenu();
                break;
            case 0:
                exit();
                break;
            default:
                log.info(ERROR_STR);
                exit();
        }

        System.out.println(ASK_STR + options);
    }

}
