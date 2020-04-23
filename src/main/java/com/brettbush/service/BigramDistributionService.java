package com.brettbush.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BigramDistributionService {

    public Map<String, Integer> calculateDistribution(List<String> bigrams){
        Map<String, Integer> returnValue = new TreeMap<>();

        bigrams.stream()
                .forEach(bigram -> {
                    //If the bigram exists, add one to the count
                    returnValue.computeIfPresent(bigram,
                            (key, value) -> (value + 1));
                    //If it doesn't exist, count is 1
                    returnValue.putIfAbsent(bigram, 1);
                });

        return returnValue;
    }
}
