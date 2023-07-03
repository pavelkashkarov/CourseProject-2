package project;

import project.log.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Config instance;
    private static final Logger LOGGER = Logger.getInstance();
    private static final String PATH = "./config/settings.properties";

    private int port;
    private String host;

    private Config() {
        try (FileReader fileReader = new FileReader(PATH)) {
            Properties props = new Properties();
            props.load(fileReader);

            port = Integer.parseInt(props.getProperty("port"));
            host = props.getProperty("host");
        } catch (IOException e) {
            LOGGER.log("Ошибка в конструкторе у класса " + Config.class.getName());
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
