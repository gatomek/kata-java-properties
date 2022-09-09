package pl.gatomek;

import lombok.extern.log4j.Log4j2;
import pl.gatomek.hr.Address;
import pl.gatomek.hr.User;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

@Log4j2
public class AppPropertiesDemo {

    public static void demoToStringLombok() {
        User user = new User();
        user.setName("Bill");
        user.setAge(40);

        user.setAdresses(new ArrayList<>(Arrays.asList(new Address( "Lodz"), new Address( "Warsaw"))));
        log.info(user.toString());
    }

    public static void demoPlainPropertiesFileLoading() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String propsFilePath = rootPath + "application.properties";
            Properties props = new Properties();
            File file = new File( propsFilePath);
            props.load(Files.newInputStream(file.toPath()));

            log.info("Version: " + props.getProperty("version"));
            log.info("Company: " + props.getProperty("company", "DefaultCompany"));
        } catch (NullPointerException ex) {
            log.error("! NullPointerException");
        } catch (Exception ex) {
            log.error("! Exception");
        }
    }

    public static void demoXmlPropertiesFileLoading() {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String propsFilePath = rootPath + "properties.xml";
            Properties props = new Properties();
            File file = new File( propsFilePath);
            props.loadFromXML(Files.newInputStream(file.toPath()));

            log.info("File Icon: " + props.getProperty("fileIcon"));
        } catch (NullPointerException ex) {
            log.error("! NullPointerException");
        } catch (Exception ex) {
            log.error("! Exception");
        }
    }

    public static void demoLogLevels() {
        log.info(":) Info");
        log.warn(":| Warning");
        log.error(":( Error");
    }

    public static void main(String[] args) {
        demoPlainPropertiesFileLoading();
        demoXmlPropertiesFileLoading();
        demoLogLevels();
        demoToStringLombok();
    }
}