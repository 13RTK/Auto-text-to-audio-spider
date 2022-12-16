package org.alex.text2speech.menu;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.util.InputValidator;
import org.alex.text2speech.util.PropsUtil;

import java.util.Scanner;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Menu {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String ASK_STR = "是否还需要进行其他操作？\n";
    public static final String EMAIL = PropsUtil.getContactProperty("email");
    public static final String ERROR_STR = "输入有误，且未被验证器拦截";
    public static final String DIRECTORY_REMIND = "（以斜线结尾，否则会保存在指定目录的同级目录中，转换后的音频文件会和源文本文件处于同一目录下）";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final boolean IS_MAC = OS_NAME.toLowerCase().contains("mac");
    public static final String EXIT_STR = "0 : 退出\n";
    public static final String BACK_MAIN_MENU_STR = "7 : 回到主菜单\n";
    public static final String MENU_COMPONENT_DELIMITER = "==========================================";

    public static void mainMenu() {
        String options = "1 : 爬取小说\n" +
                "2 : 将文本内容/文本文件转换为音频\n" +
                EXIT_STR;
        System.out.println(MENU_COMPONENT_DELIMITER);
        System.out.println("检测到您的系统为: " + System.getProperty("os.name") + "\n");
        System.out.println("欢迎使用Alex出品的Spider-Text-Speech工具，目前只能爬取《斗罗大陆1》，之后会陆续更新其他小说，目前只支持中文小说\n");
        System.out.println("请输入对应的数字来选择你需要的功能: \n" + options);
        System.out.println("\n\n没有喜欢的小说？请将你喜欢的小说名称发送到下面这个邮箱中，开发者看到后会努力上架的！\n");
        System.out.println("联系邮箱: " + EMAIL + " 如果能提供小说对应的免费阅读网址，该本小说的上线速度会更快哦！");
        System.out.println(MENU_COMPONENT_DELIMITER);

        int inputNum = InputValidator.getValidateNumberFromInput(0, 2, options);
        switch (inputNum) {
            case 1:
                SpiderMenu.mainMenu();
                break;
            case 2:
                Text2SpeechMenu.MainMenu();
                break;
            case 0:
                exit();
                break;
            case 7:
                System.out.println("你已在主菜单");
                break;
            default:
                log.warning(ERROR_STR);
                exit();
        }
    }


    public static void exit() {
        System.exit(0);
    }
}
