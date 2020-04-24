package com.brettbush.service;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileDataServiceTest {

    private final FileDataService fileDataService = new FileDataService();

    private static final String JAR_PATH = new File(
            FileDataServiceTest.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath()).toString();

    @Test
    public void verifyFilePathTest() {
        assertThrows(FileNotFoundException.class, () -> {
            fileDataService.readFileData(JAR_PATH + "/Fox.txt");
        });
    }

    @Test
    public void verifyDataReturnedFromFileTest() throws IOException {
        assertEquals("The quick brown fox and the quick blue hare.",
                fileDataService.readFileData(JAR_PATH + "/FoxHare.txt"));
    }
}
