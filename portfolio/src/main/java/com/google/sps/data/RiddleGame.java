package com.google.sps.data;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RiddleGame {
    private HashMap<String, String> riddleMap = new HashMap<String, String>();
    private final String correctResponse = "YOU'RE CORRECT!!!";
    private final String incorrectResponse = 
        "That was not the answer we were looking for. :(";

    public RiddleGame() {
        Random rand = new Random();
        riddleMap.put("What is greater than God,<br/>more evil than the devil," +
            "<br/>the poor have it,<br/>the rich need it,<br/>and if you" + 
            " eat it, you\'ll die?",
            "\'Nothing\'");
        riddleMap.put("I am the beginning of the end,<br/>and the end of time " +
            "and space.<br/>I am essential to creation,<br/>and I surround " +
            "every place.<br/>What am I?",
            "\'The letter E\'");
        riddleMap.put("What always runs but never walks,<br/>often murmurs but " +
            "never talks,<br/>has a bed but never sleeps,<br/>has a mouth " +
            "but never eats?", 
            "\'A river\'");
        riddleMap.put("I never was, am always to be.<br/>No one ever saw me, " +
            "nor ever will.<br/>And yet I am the confidence of all.<br/>To " +
            "live and breath on this terrestrial ball.<br/>What am I?",
            "\'The future\'");
        riddleMap.put("Kings and queens may cling to power and the jester\'s" +
            " got his call.<br/>But, as you may all discover, the common one" +
            " outranks them all.",
            "\'An ace\'");
    }

    public String checkAnswer(String question,
                              String guess,
                              boolean showAnswer) {
        question = cleanString(question);
        guess = cleanString(guess);

        String solutionString = checkCorrect(question, guess) ? 
                                    correctResponse : incorrectResponse;

        if (showAnswer) {
            solutionString += getSolution(question);
        }

        return createRiddleJSONString(question, solutionString);
    }

    public String setUpRiddle() {
        String riddle = getRiddle();
        return createRiddleJSONString(riddle, "");
    }

    private String getRiddle() {
        Random rand = new Random();
        return (String) riddleMap.keySet()
            .toArray()[rand.nextInt(riddleMap.size())];
    }

    private boolean checkCorrect(String question, String guess) {
        return riddleMap.get(question).equalsIgnoreCase(guess);
    }

    private String getSolution(String question) {
        return " Answer:" + riddleMap.get(question);
    }

    private String createRiddleJSONString(String question,
                                          String solution) {
        String riddleJSON = 
        "{" +
            "\"riddleSolution\":\"" + solution + "\"," +
            "\"riddleQuestion\":\"" + question + "\"" +
        "}";
        return riddleJSON;
    }

    private String cleanString(String str) {
        str = str.replace("%3C", "<");
        str = str.replace("%3E", ">");
        str = str.replace("%20", " ");
        str = str.replace("%27", "\'");
        return str;
    }
}