package com.brettbush;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
