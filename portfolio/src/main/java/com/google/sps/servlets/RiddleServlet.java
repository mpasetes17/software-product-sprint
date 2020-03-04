package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import com.google.sps.data.RiddleGame;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/riddle")
public final class RiddleServlet extends HttpServlet {
    private RiddleGame game = new RiddleGame();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String outputString = game.getRiddleGameOutput();
        outputString = "<p><b>" + outputString + "</b></p>";

        response.setContentType("text/html;");
        response.getWriter().println(outputString);


/*
        Query query = new Query("Task").addSort("timestamp", SortDirection.DESCENDING);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery results = datastore.prepare(query);

        List<String> guessHistory = new ArrayList<>();
        for (Entity entity : results.asIterable()) {
            long id = entity.getKey().getId();
            String question = (String) entity.getProperty("riddleQuestion");
            String guess = (String) entity.getProperty("answerGuess");

            String riddle = "Q: " + question + "\nG: " + guess;
            guessHistory.add(riddle);
        }

        Gson gson = new Gson();

        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(guessHistory));
        */
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerGuess = request.getParameter("riddle-guess");
        boolean showAnswer = Boolean.valueOf(request.getParameter("show-answer"));
        boolean getNewRiddle = false;

        Entity taskEntity = new Entity("Task");
        taskEntity.setProperty("riddleQuestion", answerGuess);
        taskEntity.setProperty("answerGuess", answerGuess);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(taskEntity);

        String outputString = game.checkAnswer(answerGuess, showAnswer);
        response.setContentType("text/html;");
        response.getWriter().println(outputString);
    
        response.sendRedirect("/index.html");
    }
}
