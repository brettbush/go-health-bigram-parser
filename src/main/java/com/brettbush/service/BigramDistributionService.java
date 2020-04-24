package com.brettbush.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BigramDistributionService {

    public Map<String, Integer> calculateDistribution(List<String> bigrams){
        Map<String, Integer> returnValue = new LinkedHashMap<>();

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
