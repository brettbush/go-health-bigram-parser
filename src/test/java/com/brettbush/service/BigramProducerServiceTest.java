package com.brettbush.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BigramProducerServiceTest {

    private final BigramProducerService bigramProducerService = new BigramProducerService();

    @Test
    public void verifyBigramsTest(){
        final String text = "The quick brown fox and the quick blue hare.  ";

        List<String> bigrams = bigramProducerService.parseBigrams(text);
        assertNotNull(bigrams);
        assertEquals(8, bigrams.size());

        assertEquals("the quick", bigrams.get(0));
        assertEquals("quick brown", bigrams.get(1));
        assertEquals("brown fox", bigrams.get(2));
        assertEquals("fox and", bigrams.get(3));
        assertEquals("and the", bigrams.get(4));
        assertEquals("the quick", bigrams.get(5));
        assertEquals("quick blue", bigrams.get(6));
        assertEquals("blue hare", bigrams.get(7));
    }

    @Test
    public void verifyEmptyReturnForNullInputTest(){
        final String text = null;

        List<String> bigrams = bigramProducerService.parseBigrams(text);
        assertNotNull(bigrams);
        assertEquals(0, bigrams.size());
    }

    @Test
    public void verifyEmptyReturnForEmptyInputTest(){
        final String text = "";

        List<String> bigrams = bigramProducerService.parseBigrams(text);
        assertNotNull(bigrams);
        assertEquals(0, bigrams.size());
    }

    @Test
    public void verifyPunctuationRemovedTest(){
        final String text = "Gratuitous, use; of! punctuation\" text' here.";

        List<String> bigrams = bigramProducerService.parseBigrams(text);

        assertEquals("gratuitous use", bigrams.get(0));
        assertEquals("use of", bigrams.get(1));
        assertEquals("of punctuation", bigrams.get(2));
        assertEquals("punctuation text", bigrams.get(3));
        assertEquals("text here", bigrams.get(4));
    }

    @Test
    public void verifyBigramsFromMultilineTextTest(){
        final String text = "Several\tshort sentences.\nSo I don't have to work too hard.\rThanks!\r\n";

        List<String> bigrams = bigramProducerService.parseBigrams(text);

        assertEquals("several short", bigrams.get(0));
        assertEquals("short sentences", bigrams.get(1));
        assertEquals("sentences so", bigrams.get(2));
        assertEquals("so i", bigrams.get(3));
        assertEquals("i dont", bigrams.get(4));
        assertEquals("dont have", bigrams.get(5));
        assertEquals("have to", bigrams.get(6));
        assertEquals("to work", bigrams.get(7));
        assertEquals("work too", bigrams.get(8));
        assertEquals("too hard", bigrams.get(9));
        assertEquals("hard thanks", bigrams.get(10));
    }
}
