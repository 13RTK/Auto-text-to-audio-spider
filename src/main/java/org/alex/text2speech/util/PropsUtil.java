package org.alex.text2speech.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropsUtil {
    private final static Properties properties;

    static {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("book.properties");
        properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
