package com.brettbush.service;

import java.io.PrintStream;
import java.util.Map;

public class ConsoleOutputService {

    public static final String BREAK_LINE = "~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/";

    public ConsoleOutputService(){
    }

    public void writeDistributionToConsole(
            PrintStream printStream,
            Map<String, Integer> distribution){
        printStream.println(BREAK_LINE);

        distribution.entrySet().forEach(stringIntegerEntry -> {
            String bigram = stringIntegerEntry.getKey();
            int occuranceCount = stringIntegerEntry.getValue();

            printStream.println(String.format("%s\t(%d)", bigram, occuranceCount));

        });

        printStream.println(BREAK_LINE);
    }
}
