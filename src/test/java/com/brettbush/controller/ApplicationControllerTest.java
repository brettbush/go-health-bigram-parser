package com.brettbush.controller;

import com.brettbush.service.BigramDistributionService;
import com.brettbush.service.BigramProducerService;
import com.brettbush.service.FileDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationControllerTest {

    private FileDataService fileDataService;
    private BigramProducerService bigramProducerService;
    private BigramDistributionService bigramDistributionService;
    private ApplicationController applicationController;

    @BeforeEach
    public void setup(){
        fileDataService = new FileDataService();
        bigramProducerService = new BigramProducerService();
        bigramDistributionService = new BigramDistributionService();

        applicationController = new ApplicationController(fileDataService, bigramProducerService, bigramDistributionService);
    }

    @Test
    public void verifyFileExistsTest(){
        assertThrows(FileNotFoundException.class, () -> {
            applicationController.processFile("HappyFox.txt");
        });
    }

    @Test
    public void fullRunTest() throws IOException {
        Map<String, Integer> bigramDistribution = applicationController.processFile("FoxHare.txt");;

        assertEquals(7, bigramDistribution.size());

        assertEquals(2, bigramDistribution.get("the quick"));
        assertEquals(1, bigramDistribution.get("quick brown"));
        assertEquals(1, bigramDistribution.get("brown fox"));
        assertEquals(1, bigramDistribution.get("fox and"));
        assertEquals(1, bigramDistribution.get("and the"));
        assertEquals(1, bigramDistribution.get("quick blue"));
        assertEquals(1, bigramDistribution.get("blue hare"));
    }
}
