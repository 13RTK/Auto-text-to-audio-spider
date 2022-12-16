package org.alex.text2speech.util.file;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.alex.text2speech.menu.Menu;

import java.io.File;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FilePathUtil {

    public static String getDefaultAudioFileNameFromSrcPath(String srcPath) {
        File file = new File(srcPath);
        String fileName = file.getName().split("\\.")[0];
        String pathDelimiter;

        if (Menu.IS_MAC) {
            pathDelimiter = "/";
        } else {
            pathDelimiter = "\\";
        }

        return file.getParent() + pathDelimiter + fileName + ".mp3";
    }
}
