package com.brettbush.service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileDataService {

    public String readFileData(String fileNameAndPath) throws IOException {
        File file = new File(fileNameAndPath);
        return FileUtils.readFileToString(file, "UTF-8");
    }
}
