package org.example.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;

@Data
@Slf4j
public class City {
    private String slug;
    private Coords coords;

    public void toXml(String filePath) {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(filePath);
        try {
            log.info("Попытка сохранить объект City в XML-файл. Имя файла: {}", file.getAbsolutePath());
            xmlMapper.writeValue(file, this);
            log.info("Объект City успешно сохранен в XML-файл. Имя файла: {}", file.getAbsolutePath());
        } catch (IOException e) {
            log.error("Ошибка при сохранении объекта City в XML-файл. Имя файла: {}. Ошибка: {}", file.getAbsolutePath(), e.getMessage());
        }
    }
}