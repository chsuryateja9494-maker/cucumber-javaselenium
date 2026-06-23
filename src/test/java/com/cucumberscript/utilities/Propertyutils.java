package com.cucumberscript.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyutils {
    static Properties props = new Properties();
    static FileInputStream fis = null;

    public static void loadProps(String propertiesPath) throws IOException {
        fis = new FileInputStream(propertiesPath);  //A FileInputStream obtains input bytes from a file in a file system. What files are available depends on the host environment.
        props.load(fis);   //load = Reads a property list (key and element pairs) from the input byte stream.
    }

    public static Properties loadApplicationProperties() throws IOException {
        loadProps("src/test/resources/config/application.properties");
        return props;
    }

    public static Properties loadFrameworkProperties() throws IOException {
        loadProps("src/test/resources/config/framework.properties");
        return props;
    }

    public static Properties loadUserProperties() throws IOException {
        loadProps("src/test/resources/config/user.properties");
        return props;
    }

}
