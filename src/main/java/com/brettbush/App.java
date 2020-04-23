package com.brettbush;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IllegalArgumentException, FileNotFoundException {
        if((null == args) || (0 == args.length)){
            throw new IllegalArgumentException("You must supply a file name as an argument.");
        }

        String fileWithPath = args[0];
        URL fileLocation = App.class.getClassLoader().getResource(fileWithPath);
        if(null == fileLocation){
            throw new FileNotFoundException(String.format("File '%s' must exist.", fileWithPath));
        }
    }
}
