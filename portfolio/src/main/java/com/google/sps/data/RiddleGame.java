package com.google.sps.data;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RiddleGame {
    private HashMap<String, String> riddleMap = new HashMap<String, String>();
    private String currentRiddle;
    private String outputString;

    public RiddleGame() {
        Random rand = new Random();
        riddleMap.put("What is greater than God,<br/>more evil than the devil," +
            "<br/>the poor have it,<br/>the rich need it,<br/>and if you" + 
            " eat it, you&apos;ll die?",
            "Nothing");
        riddleMap.put("I am the beginning of the end,<br/>and the end of time " +
            "and space.<br/>I am essential to creation,<br/>and I surround " +
            "every place.<br/>What am I?",
            "The letter E");
        riddleMap.put("What always runs but never walks,<br/>often murmurs but " +
            "never talks,<br/>has a bed but never sleeps,<br/>has a mouth " +
            "but never eats?", 
            "A river");
        riddleMap.put("I never was, am always to be.<br/>No one ever saw me, " +
            "nor ever will.<br/>And yet I am the confidence of all.<br/>To " +
            "live and breath on this terrestrial ball.<br/>What am I?",
            "The future");
        riddleMap.put("Kings and queens may cling to power and the jester&apos;s" +
            " got his call.<br/>But, as you may all discover, the common one" +
            " outranks them all.",
            "An ace");
        outputString = setNewRiddle();
    }
    
    private String setNewRiddle() {
        Random rand = new Random();
        currentRiddle = (String) riddleMap.keySet()
            .toArray()[rand.nextInt(riddleMap.size())];
        return currentRiddle;
    }

    public String getRiddleGameOutput() {
        return outputString;
    }

    public String checkAnswer(String guess, boolean showAnswer) {
        String newRiddle = currentRiddle;
        outputString = "";
        boolean getNewRiddle = false;
        
        //check if answer is correct
        if(riddleMap.get(currentRiddle).equalsIgnoreCase(guess)) {
            outputString += "YOU&apos;RE CORRECT!!!<br/><br/>";
            getNewRiddle = true;
        }
        else {
            outputString += "That was not the answer we were looking " +
                            "for. :(<br/><br/>";
        }

        //if showing answer, display old riddle and its answer
        if(showAnswer) {
            outputString += "<b>Q:</b> " + currentRiddle;
            outputString += "<br/><b>A:</b> " + riddleMap.get(currentRiddle);
            outputString += "<br/><br/>";
            getNewRiddle = true;
        }

        //get new riddle if needed
        if (getNewRiddle) {
            newRiddle = setNewRiddle();
        }

        outputString +=  "<b>" + newRiddle + "</b>";
        outputString = "<p>" + outputString + "</p>";
        return outputString;
    }
}