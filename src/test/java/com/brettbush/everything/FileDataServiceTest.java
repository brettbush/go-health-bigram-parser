package com.brettbush.everything;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileDataServiceTest {

    private final FileDataService fileDataService = new FileDataService();

    @Test
    public void verifyFilePathTest() {
        assertThrows(FileNotFoundException.class, () -> {
            fileDataService.readFileData("Fox.txt");
        });
    }

    @Test
    public void verifyDataReturnedFromFileTest() throws IOException {
        assertEquals("The quick brown fox and the quick blue hare.",
                fileDataService.readFileData("FoxHare.txt"));
    }
}
