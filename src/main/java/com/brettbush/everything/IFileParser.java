package com.brettbush.everything;

import java.io.FileNotFoundException;

public interface IFileParser {

    String readFileData(String fileWithPath) throws FileNotFoundException;
}
