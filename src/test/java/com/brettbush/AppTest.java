package com.brettbush;

import com.brettbush.everything.IFileParser;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Unit test for simple App.
 */
public class AppTest {

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
    public void verifyFileExistsTest(){
        assertThrows(FileNotFoundException.class, () -> {
            App.main(new String[]{"HappyFox.txt"});
        });
    }
}
