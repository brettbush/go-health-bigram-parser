package com.brettbush.service;

import java.util.ArrayList;
import java.util.List;

public class BigramProducerService {

    public List<String> parseBigrams(String text){
        List<String> returnValue = new ArrayList<>();

        if(null != text){
            String[] lowerCaseWords = parseWords(text);

            for(int i = 0; i < (lowerCaseWords.length - 1); i++){
                String first = lowerCaseWords[i];
                String second = lowerCaseWords[i + 1];
                returnValue.add(constructBigram(first, second));
            }
        }

        return returnValue;
    }

    private String[] parseWords(String text){
        String[] returnValue = null;

        String trimmed = text.trim();
        String strippedOfEOL = trimmed.replaceAll("[\\n\\r\\t]", " ");
        String strippedOfPunctuation = strippedOfEOL.replaceAll("[^a-zA-Z ]", "");
        returnValue = strippedOfPunctuation.toLowerCase().split("\\s+");

        return returnValue;
    }

    private String constructBigram(String first, String second){
        return String.format("%s %s", first, second);
    }
}
