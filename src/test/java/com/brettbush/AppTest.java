package com.brettbush;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String JAR_PATH = new File(
            AppTest.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .getPath()).toString();

    @Test
    public void verifyArgumentsTest() {
        assertThrows(IllegalArgumentException.class, () -> {
                App.main(new String[0]);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            App.main(null);
        });
    }

    @Test
    public void endToEndTest() throws IOException {
        App.main(new String[]{JAR_PATH + "/FoxHare.txt"});
    }
}
