package com.google.sps.servlets;

import java.io.IOException;
import java.lang.Math;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/riddle")
public final class RiddleServlet extends HttpServlet {
    int currentRiddle = -1;
    String outputString = "";
    String[] riddleQuestions = new String[] {
        "What is greater than God,<br/>more evil than the devil," +
            "<br/>the poor have it,<br/>the rich need it,<br/>and if you eat " +
            "it, you&apos;ll die?",
        "I am the beginning of the end,<br/>and the end of time and " +
            "space.<br/>I am essential to creation,<br/>and I surround every " +
            "place.<br/>What am I?",
        "What always runs but never walks,<br/>often murmurs but never " +
            "talks,<br/>has a bed but never sleeps,<br/>has a mouth but never eats?",
        "I never was, am always to be.<br/>No one ever saw me, nor ever will.<br/>" +
            "And yet I am the confidence of all.<br/>To live and breath on " +
            "this terrestrial ball.<br/>What am I?",
        "Kings and queens may cling to power and the jester&apos;s got his " +
        "call.<br/>But, as you may all discover, the common one outranks them all."
    };
    String[] riddleSolutions = new String[] {
        "Nothing", "The letter E", "A river", "The future", "An ace"
    };
    int numRiddles = Math.min(riddleQuestions.length, riddleSolutions.length);

    Random rand = new Random();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(currentRiddle == -1) {
            currentRiddle = rand.nextInt(numRiddles);
            outputString = riddleQuestions[currentRiddle];
            outputString = "<p><b>" + outputString + "</b></p>";
        }
            response.setContentType("text/html;");
            response.getWriter().println(outputString);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerGuess = request.getParameter("riddle-guess");
        boolean showAnswer = Boolean.valueOf(request.getParameter("show-answer"));
        boolean getNewRiddle = false;
        outputString = "";

        //check if answer is correct
        if(riddleSolutions[currentRiddle].equalsIgnoreCase(answerGuess)) {
            outputString += "YOU&apos;RE CORRECT!!!<br/><br/>";
            getNewRiddle = true;
        }
        else {
            outputString += "That was not the answer we were looking for. :(<br/><br/>";
        }

        //if showing answer, display old riddle and its answer
        if(showAnswer) {
            outputString += "<b>Q:</b> " + riddleQuestions[currentRiddle];
            outputString += "<br/><b>A:</b> " + riddleSolutions[currentRiddle];
            outputString += "<br/><br/>";
            getNewRiddle = true;
        }

        //get new riddle if needed
        if(getNewRiddle) {
            int oldRiddle = currentRiddle;
            while (oldRiddle == currentRiddle) {
                currentRiddle = rand.nextInt(numRiddles);
            }
        }

        outputString +=  "<b>" + riddleQuestions[currentRiddle] + "</b>";
        outputString = "<p>" + outputString + "</p>";
        response.setContentType("text/html;");
        response.getWriter().println(outputString);
    
        response.sendRedirect("/index.html");
    }
}
