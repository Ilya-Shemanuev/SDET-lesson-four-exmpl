package ru.x5.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс реализует взаимодействие с параметрами проекта
 */
public class EnvProperties {

    /**
     * Обычный поток чтения файла
     */
    protected static FileInputStream fileInputStream;

    /**
     * Обычная переменная типа Properties, которая хранит все наши параметры
     */
    protected static Properties properties;

    /**
     * В этом статик блоке описывает процесс чтения файла параметров
     * и их запись в переменную properties
     */
    static {
        try {
            fileInputStream = new FileInputStream("environment.properties");
                    properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Метод возвращает значение параметра по его ключу
     * @param key - ключ параметра, который можно найти в файле environment.properties слева от знака равно
     * @return значение параметра которое расположено справа от знака равно
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
