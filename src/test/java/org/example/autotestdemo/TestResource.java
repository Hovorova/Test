package org.example.autotestdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestResource {
    private static final String TEST_RESOURCE = "src/test/resources/TestResource.properties";

    protected static FileInputStream fileInputStream;
    protected static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream(TEST_RESOURCE);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Can not open resource file", e);
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}