package com.brettbush.controller;

import com.brettbush.service.BigramDistributionService;
import com.brettbush.service.BigramProducerService;
import com.brettbush.service.ConsoleOutputService;
import com.brettbush.service.FileDataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApplicationController {

    private final FileDataService fileDataService;
    private final BigramProducerService bigramProducerService;
    private final BigramDistributionService bigramDistributionService;
    private final ConsoleOutputService consoleOutputService;

    public ApplicationController(
            FileDataService fileDataService,
            BigramProducerService bigramProducerService,
            BigramDistributionService bigramDistributionService,
            ConsoleOutputService consoleOutputService){
        this.fileDataService = fileDataService;
        this.bigramProducerService = bigramProducerService;
        this.bigramDistributionService = bigramDistributionService;
        this.consoleOutputService = consoleOutputService;
    }

    public Map<String, Integer> processFile(String fileNameAndPath) throws IOException {
        String fileContent = fileDataService.readFileData(fileNameAndPath);
        List<String> bigrams = bigramProducerService.parseBigrams(fileContent);
        return bigramDistributionService.calculateDistribution(bigrams);
    }

    public void writeToConsole(Map<String, Integer> bigramDistribution){
        consoleOutputService.writeDistributionToConsole(System.out, bigramDistribution);
    }
}
