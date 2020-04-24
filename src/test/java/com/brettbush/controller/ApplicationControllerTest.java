package com.brettbush.controller;

import com.brettbush.service.BigramDistributionService;
import com.brettbush.service.BigramProducerService;
import com.brettbush.service.ConsoleOutputService;
import com.brettbush.service.FileDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationControllerTest {

    private static final String JAR_PATH = new File(
            ApplicationControllerTest.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath()).toString();

    private FileDataService fileDataService;
    private BigramProducerService bigramProducerService;
    private BigramDistributionService bigramDistributionService;
    private ConsoleOutputService consoleOutputService;
    private ApplicationController applicationController;

    @BeforeEach
    public void setup(){
        fileDataService = new FileDataService();
        bigramProducerService = new BigramProducerService();
        bigramDistributionService = new BigramDistributionService();
        consoleOutputService = Mockito.spy(new ConsoleOutputService());

        applicationController = new ApplicationController(
                fileDataService,
                bigramProducerService,
                bigramDistributionService,
                consoleOutputService);
    }

    @Test
    public void fullConversionTest() throws IOException {
        Map<String, Integer> bigramDistribution = applicationController.processFile(JAR_PATH + "/FoxHare.txt");;

        assertEquals(7, bigramDistribution.size());

        assertEquals(2, bigramDistribution.get("the quick"));
        assertEquals(1, bigramDistribution.get("quick brown"));
        assertEquals(1, bigramDistribution.get("brown fox"));
        assertEquals(1, bigramDistribution.get("fox and"));
        assertEquals(1, bigramDistribution.get("and the"));
        assertEquals(1, bigramDistribution.get("quick blue"));
        assertEquals(1, bigramDistribution.get("blue hare"));
    }

    @Test
    public void writeToStreamTest(){
        Map<String, Integer> bigramDistribution = new LinkedHashMap<>();

        bigramDistribution.put("the quick", 2);
        bigramDistribution.put("quick brown", 1);
        bigramDistribution.put("brown fox", 2);
        bigramDistribution.put("fox and", 3);

        applicationController.writeToConsole(bigramDistribution);

        Mockito.verify(consoleOutputService).writeDistributionToConsole(System.out, bigramDistribution);
    }

}
