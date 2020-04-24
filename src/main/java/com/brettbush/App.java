package com.brettbush;

import com.brettbush.controller.ApplicationController;
import com.brettbush.service.BigramDistributionService;
import com.brettbush.service.BigramProducerService;
import com.brettbush.service.ConsoleOutputService;
import com.brettbush.service.FileDataService;

import java.io.IOException;
import java.util.Map;

/**
 * See readme for operation instructions
 */
public class App {

    public static void main(String[] args) throws IllegalArgumentException, IOException {
        if((null == args) || (0 == args.length)){
            throw new IllegalArgumentException("You must supply a file name as an argument.");
        }

        String fileNameAndPath = args[0];
        FileDataService fileDataService = new FileDataService();
        BigramProducerService bigramProducerService = new BigramProducerService();
        BigramDistributionService bigramDistributionService = new BigramDistributionService();
        ConsoleOutputService consoleOutputService = new ConsoleOutputService();

        ApplicationController applicationController = new ApplicationController(
                fileDataService,
                bigramProducerService,
                bigramDistributionService,
                consoleOutputService);
        Map<String, Integer> distribution = applicationController.processFile(fileNameAndPath);
        applicationController.writeToConsole(distribution);
    }
}
