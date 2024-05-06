package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesReaderTest {

    @Test
    void getDbConnectionUrlTest() {
        String expectedResult = "jdbc:postgresql://localhost:5432/goit_database?currentSchema=client_planet_ticket_schema";
        String actualResult = PropertiesReader.getDbConnectionUrl();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDbUsernameTest() {
        String expectedResult = "postgres";
        String actualResult = PropertiesReader.getDbUsername();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDbPasswordTest() {
        String expectedResult = "postgres";
        String actualResult = PropertiesReader.getDbPassword();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void createInputStreamTest() throws IOException {
        InputStream expectedStream = PropertiesReader.class.getClassLoader().getResourceAsStream("hibernate.properties");
        InputStream actualStream = PropertiesReader.createInputStream();

        Assertions.assertNotNull(expectedStream);
        Assertions.assertNotNull(actualStream);

        byte[] expectedBytes = expectedStream.readAllBytes();
        byte[] actualBytes = actualStream.readAllBytes();

        Assertions.assertArrayEquals(expectedBytes, actualBytes);
    }
}