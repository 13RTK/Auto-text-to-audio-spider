package org.alex.text2speech.menu;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.util.InputValidator;
import org.alex.text2speech.util.azure.Text2SpeechUtil;
import org.alex.text2speech.util.file.FilePathUtil;

import static org.alex.text2speech.menu.Menu.*;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Text2SpeechMenu {
    public static String textFileSavePath;
    public static String AUDIO_PROCESSING_STR = "正在转换，请稍后...";
    public static final String CONVERT_COMPLETE_REMIND = "转换完成, 请在对应的路径中查看: ";

    public static void MainMenu() {
        String options = "1 : 将指定路径下的所有文本文件转换为音频文件\n" +
                "2 : 将指定文件转换为音频文件\n" +
                "3 : 将文本转换为音频文件\n" +
                BACK_MAIN_MENU_STR + EXIT_STR;

        System.out.println(MENU_COMPONENT_DELIMITER);
        System.out.println("欢迎使用音频处理功能，请根据您的情况选择功能：\n" + options);
        System.out.println(MENU_COMPONENT_DELIMITER);

        int inputNum = InputValidator.getValidateNumberFromInput(0, 3, options);
        executeByInputOption(inputNum);

        operateAskAfterConvert(options);
    }

    private static void operateAskAfterConvert(String options) {
        System.out.println(MENU_COMPONENT_DELIMITER);
        System.out.println(ASK_STR + options);
        System.out.println(MENU_COMPONENT_DELIMITER);

        int inputNum = InputValidator.getValidateNumberFromInput(0, 3, options);
        executeByInputOption(inputNum);

        operateAskAfterConvert(options);
    }

    private static void executeByInputOption(int inputNum) {
        System.out.println(MENU_COMPONENT_DELIMITER);
        switch (inputNum) {
            case 1:
                System.out.println("请输入需要转换的文本文件所在的文件夹路径: " + DIRECTORY_REMIND);
                textFileSavePath = scanner.nextLine();

                System.out.println(AUDIO_PROCESSING_STR);
                Text2SpeechUtil.batchConvertFile2Wav(textFileSavePath, textFileSavePath, Text2SpeechUtil.voiceName);
                System.out.println(CONVERT_COMPLETE_REMIND + textFileSavePath);
                break;

            case 2:
                System.out.println("请输入需要转换的文本文件保存的绝对路径，注意包含文件名和后缀: " + DIRECTORY_REMIND + "\n");
                textFileSavePath = scanner.nextLine();
                String fileOutPutName = FilePathUtil.getDefaultAudioFileNameFromSrcPath(textFileSavePath);

                System.out.println(AUDIO_PROCESSING_STR);
                Text2SpeechUtil.convertFile2Wav(textFileSavePath, fileOutPutName, Text2SpeechUtil.voiceName);
                System.out.println(CONVERT_COMPLETE_REMIND + fileOutPutName);
                break;

            case 3:
                System.out.println("请输入需要转换的文本内容: \n");
                String inputStr = scanner.nextLine();

                System.out.println("请输入生成的音频文件保存的绝对路径，注意包含文件名和后缀: ");
                String fileOutputName = scanner.nextLine();
                System.out.println(AUDIO_PROCESSING_STR);
                Text2SpeechUtil.convertStr2Wav(inputStr, fileOutputName, Text2SpeechUtil.voiceName);
                System.out.println(CONVERT_COMPLETE_REMIND + fileOutputName);
                break;

            case 7:
                mainMenu();
                break;
            case 0:
                exit();
                break;
            default:
                log.warning(ERROR_STR);
                exit();
        }
        System.out.println(MENU_COMPONENT_DELIMITER);
    }
}
