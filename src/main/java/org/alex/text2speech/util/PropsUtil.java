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
    private static final Properties contactProperties;

    static {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream bookResourceAsStream = contextClassLoader.getResourceAsStream("book.properties");
        InputStream azureResourceStream = contextClassLoader.getResourceAsStream("azure.properties");
        InputStream contactResourceStream = contextClassLoader.getResourceAsStream("contact.properties");

        bookProperties = new Properties();
        azureProperties = new Properties();
        contactProperties = new Properties();

        try {
            bookProperties.load(bookResourceAsStream);
            azureProperties.load(azureResourceStream);
            contactProperties.load(contactResourceStream);
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

    public static String getContactProperty(String propertyName) {
        return contactProperties.getProperty(propertyName);
    }
}
