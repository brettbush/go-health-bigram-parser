package com.brettbush.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BigramDistributionServiceTest {

    private final BigramDistributionService bigramDistributionService = new BigramDistributionService();

    @Test
    public void verifyEmptyListCountTest(){
        Map<String, Integer> bigramDistribution = bigramDistributionService.calculateDistribution(new ArrayList<>());

        assertNotNull(bigramDistribution);
        assertTrue(bigramDistribution.isEmpty());
    }

    @Test
    public void verifySimpleListCountTest(){
        final List<String> foxList = Arrays.asList(
                "the quick",
                "quick brown",
                "brown fox",
                "fox and",
                "and the",
                "the quick",
                "quick blue",
                "blue hare"
        );

        Map<String, Integer> bigramDistribution = bigramDistributionService.calculateDistribution(foxList);

        assertEquals(7, bigramDistribution.size());

        assertEquals(2, bigramDistribution.get("the quick"));
        assertEquals(1, bigramDistribution.get("quick brown"));
        assertEquals(1, bigramDistribution.get("brown fox"));
        assertEquals(1, bigramDistribution.get("fox and"));
        assertEquals(1, bigramDistribution.get("and the"));
        assertEquals(1, bigramDistribution.get("quick blue"));
        assertEquals(1, bigramDistribution.get("blue hare"));
    }

    @Test
    public void verifyMoreComplexListCountTest(){
        final List<String> longList = Arrays.asList(
            "long list",
            "list with",
            "long list",
            "list with",
            "long list",
            "quick crazy",
            "racy condition",
            "list with",
            "long list",
            "racy condition",
            "masterfully done",
            "masterfully done",
            "overall outrageous"
        );

        Map<String, Integer> bigramDistribution = bigramDistributionService.calculateDistribution(longList);

        assertEquals(6, bigramDistribution.size());

        assertEquals(4, bigramDistribution.get("long list"));
        assertEquals(3, bigramDistribution.get("list with"));
        assertEquals(1, bigramDistribution.get("quick crazy"));
        assertEquals(2, bigramDistribution.get("racy condition"));
        assertEquals(2, bigramDistribution.get("masterfully done"));
        assertEquals(1, bigramDistribution.get("overall outrageous"));
    }
}
