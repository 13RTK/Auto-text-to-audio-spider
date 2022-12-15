package org.alex.text2speech.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropsUtilTest {

    @Test
    public void getBootProperty() {
        String bookProperty = PropsUtil.getBookProperty("douluo1.url");

        assertEquals("https://www.tangsanbooks.com/book/", bookProperty);
    }

    @Test
    public void getAzureProperty() {
        String azureProperty = PropsUtil.getAzureProperty("speech.region");

        assertEquals("koreacentral", azureProperty);
    }
}