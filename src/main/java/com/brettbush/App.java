package com.brettbush;

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

        String pathToFile = args[0];

    }
}
