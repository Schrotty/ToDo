package de.swtproject.todo.util;

import de.swtproject.todo.core.ToDo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    /**
     * The loaded properties
     */
    private Properties properties = new Properties();

    /**
     * The Singleton
     */
    private static Settings self = new Settings();

    /**
     * Get the singleton.
     *
     * @return the singleton
     */
    private static Settings getInstance() {
        return self;
    }

    /**
     * Constructor for new settings singleton.
     */
    private Settings() {
        try (InputStream input = ToDo.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Get the value of a given property.
     *
     * @param key the property
     * @return the loaded value
     */
    private String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get the jdbc connection string.
     *
     * @return the connection string
     */
    public static String getConnectionString() {
        return self.get("conString");
    }

    /**
     * Get the path for the data directory.
     *
     * @return the data dir path
     */
    public static String getDataDir() {
        return self.get("dataDir");
    }
}
