package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.City;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("�������� ��������� �����");
        ObjectMapper objectMapper = new ObjectMapper();

        log.debug("������������� json");
        try {
            log.warn("���� ����� ���� ������!");
            File file = new File("src/main/resources/city.json");
            City city = objectMapper.readValue(file, City.class);
            log.info("�������������� ������ �������: {}", city);
        } catch (IOException e) {
            log.error("������ ��� ������ �����: {}", e.getMessage());
        }
    }
}