package org.alex.text2speech.util.azure;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisOutputFormat;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.util.PropsUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import static com.microsoft.cognitiveservices.speech.SpeechSynthesisOutputFormat.Audio16Khz128KBitRateMonoMp3;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
/**
 * 将字符转换为音频文件的工具
 *
 * @author Alex
 */
public final class Text2SpeechUtil {
    private static final String KEY;
    private static final String SPEECH_REGION;
    private static String voiceName;
    private static SpeechSynthesisOutputFormat format = Audio16Khz128KBitRateMonoMp3;
    private static final SpeechConfig speechConfig;

    static {
        KEY = System.getenv("SPEECH_KEY");
        SPEECH_REGION = PropsUtil.getAzureProperty("speech.region");
        voiceName = PropsUtil.getAzureProperty("voiceName.default");

        speechConfig = SpeechConfig.fromSubscription(KEY, SPEECH_REGION);
    }

    /**
     * 将指定文件夹/路径下所有的 txt 文件转换为 mp3 格式的音频文件
     *
     * @param srcDirectoryStr 源文件夹/路径所在的路径名称
     * @param saveDirectoryStr 输出的音频文件存在的目录
     * @param customerVoiceName 用户自定义的语言音色
     */
    public static void batchConvertFile2Wav(String srcDirectoryStr, String saveDirectoryStr, String customerVoiceName) {
        Collection<File> files = FileUtils.listFiles(new File(srcDirectoryStr), null, true);

        for (File file : files) {
            String curFileName = file.getName();
            String outputAudioFileName = curFileName.split("\\.")[0] + ".mp3";

            if (!curFileName.contains(".txt")) {
                continue;
            }

            log.info("正在处理文件: " + curFileName + ", 处理后的文件名" + outputAudioFileName);
            convertFile2Wav(file, saveDirectoryStr + outputAudioFileName, customerVoiceName);
        }
    }

    /**
     * 将指定 txt 文件转换为 mp3 格式的音频文件
     *
     * @param file 源文件所在的路径名称
     * @param outputFileName 输出的音频文件名称
     * @param customerVoiceName 用户自定义的语言音色
     */
    public static void convertFile2Wav(File file, String outputFileName, String customerVoiceName) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> strings = FileUtils.readLines(file, StandardCharsets.UTF_8);
            for (String curStr : strings) {
                builder.append(curStr).append("\n");
            }
        } catch (IOException e) {
            log.warning("文本文件读取失败");
        }

        convertStr2Wav(builder.toString(), outputFileName, customerVoiceName);
    }

    /**
     * 将指定 txt 文件转换为 mp3 格式的音频文件
     *
     * @param str 需要处理的字符
     * @param outputFileName 输出的音频文件名称
     * @param customVoiceName 用户自定义的语言音色
     */
    public static void convertStr2Wav(String str, String outputFileName, String customVoiceName) {
        voiceName = customVoiceName;

        speechConfig.setSpeechSynthesisVoiceName(voiceName);
        AudioConfig audioConfig = AudioConfig.fromWavFileOutput(outputFileName);

        SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        speechSynthesizer.SpeakText(str);
    }

    /**
     * 将指定 txt 文件转换为 mp3 格式的音频文件
     *
     * @param str 需要处理的字符
     * @param outputFileName 输出的音频文件名称
     * @param customVoiceName 用户自定义的语言音色
     * @param customFormat 用户自定义的音频文件格式与码率
     */
    public static void convertStr2Wav(String str, String outputFileName, String customVoiceName, SpeechSynthesisOutputFormat customFormat) {
        voiceName = customVoiceName;
        format = customFormat;

        speechConfig.setSpeechSynthesisVoiceName(voiceName);
        speechConfig.setSpeechSynthesisOutputFormat(format);
        AudioConfig audioConfig = AudioConfig.fromWavFileOutput(outputFileName);

        SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        speechSynthesizer.SpeakText(str);
    }


}