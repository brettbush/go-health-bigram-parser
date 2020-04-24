package com.brettbush.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleOutputServiceTest {

    @Test
    public void verifyContentWrittenToStreamTest() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        ConsoleOutputService consoleOutputService = new ConsoleOutputService();

        Map<String, Integer> distribution = new LinkedHashMap<>();
        distribution.put("bird twirl", 3);
        distribution.put("maze desire", 1);
        distribution.put("infamous buffoon", 2);
        distribution.put("hardly worried", 5);
        consoleOutputService.writeDistributionToConsole(printStream, distribution);

        String expected = "~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/\n"
                        + "bird twirl\t(3)\n"
                        + "maze desire\t(1)\n"
                        + "infamous buffoon\t(2)\n"
                        + "hardly worried\t(5)\n"
                        + "~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/\n";
        String output = outputStream.toString("UTF-8");
        outputStream.close();

        assertEquals(expected, output);
    }

    @Test
    public void verifyEmptyContentWrittenToStreamTest() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream currentView = new PrintStream(outputStream);
        ConsoleOutputService consoleOutputService = new ConsoleOutputService();

        Map<String, Integer> distribution = new LinkedHashMap<>();
        consoleOutputService.writeDistributionToConsole(currentView, distribution);

        String expected = "~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/\n"
                + "~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/~/\n";
        String output = outputStream.toString("UTF-8");
        outputStream.close();

        assertEquals(expected, output);
    }
}
