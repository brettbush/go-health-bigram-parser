package com.brettbush.everything;

import com.brettbush.App;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FileDataService {

    public String readFileData(String fileWithPath) throws IOException {
        URL fileLocation = App.class.getClassLoader().getResource(fileWithPath);
        if(null == fileLocation){
            throw new FileNotFoundException(String.format("File '%s' must exist.", fileWithPath));
        }

        return FileUtils.readFileToString(new File(fileLocation.getFile()), "UTF-8");
    }
}
