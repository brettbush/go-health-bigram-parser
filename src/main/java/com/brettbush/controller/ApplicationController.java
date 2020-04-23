package com.brettbush.controller;

import com.brettbush.service.BigramDistributionService;
import com.brettbush.service.BigramProducerService;
import com.brettbush.service.FileDataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApplicationController {

    private final FileDataService fileDataService;
    private final BigramProducerService bigramProducerService;
    private final BigramDistributionService bigramDistributionService;

    public ApplicationController(
            FileDataService fileDataService,
            BigramProducerService bigramProducerService,
            BigramDistributionService bigramDistributionService){
        this.fileDataService = fileDataService;
        this.bigramProducerService = bigramProducerService;
        this.bigramDistributionService = bigramDistributionService;
    }

    public Map<String, Integer> processFile(String pathToFile) throws IOException {
        String fileContent = fileDataService.readFileData(pathToFile);
        List<String> bigrams = bigramProducerService.parseBigrams(fileContent);
        return bigramDistributionService.calculateDistribution(bigrams);
    }
}
