package com.brettbush;

import com.brettbush.service.FileDataService;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IllegalArgumentException, IOException {
        if((null == args) || (0 == args.length)){
            throw new IllegalArgumentException("You must supply a file name as an argument.");
        }

        String fileWithPath = args[0];
        FileDataService fileDataService = new FileDataService();
        String fileContent = fileDataService.readFileData(fileWithPath);
    }
}
