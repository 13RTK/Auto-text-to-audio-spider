package org.alex.text2speech.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropsUtil {
    private static final Properties bookProperties;
    private static final Properties azureProperties;

    static {
        InputStream bookResourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("book.properties");
        InputStream azureResourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("azure.properties");

        bookProperties = new Properties();
        azureProperties = new Properties();

        try {
            bookProperties.load(bookResourceAsStream);
            azureProperties.load(azureResourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBookProperty(String propertyName) {
        return bookProperties.getProperty(propertyName);
    }

    public static String getAzureProperty(String propertyName) {
        return azureProperties.getProperty(propertyName);
    }
}
