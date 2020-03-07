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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        if(null != request.getQueryString()) {
            Map<String, String> parameterMap = getParameters(request.getQueryString());
            String answerGuess = parameterMap.get("riddle-guess");
            String question = parameterMap.get("riddle-question");
            boolean showAnswer = ("%27true%27").equals(
                                        parameterMap.get("show-answer"));

            question = question.substring(3, question.length()-3);
            String outputJSON = game.checkAnswer(question, answerGuess, showAnswer);
            response.setContentType("text/html;");
            response.getWriter().println(outputJSON);
        }
        else {
            String outputString = game.setUpRiddle();
            response.setContentType("text/html;");
            response.getWriter().println(outputString);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerGuess = request.getParameter("riddle-guess");
        String question = request.getParameter("riddle-question");
        question = question.substring(3, question.length()-3);
        boolean showAnswer = Boolean.valueOf(request.getParameter("show-answer"));

        logGuess(question, answerGuess);

        String outputJSON = game.checkAnswer(question, answerGuess, showAnswer);
        response.setContentType("text/html;");
        response.getWriter().println(outputJSON);
        
        //response.sendRedirect("/index.html");
    }

    private void logGuess(String question, String guess) {
        Entity taskEntity = new Entity("Task");
        taskEntity.setProperty("riddleQuestion", question);
        taskEntity.setProperty("answerGuess", guess);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(taskEntity);
    }

    private Map<String, String> getParameters(String query)  
    {  
        String[] params = query.split("&"); 
        Map<String, String> map = new HashMap<String, String>();  
        for (String param : params)  
        {
            String name = param.split("=")[0];  
            String value = param.split("=")[1];  
            map.put(name, value);  
        }  
        return map;  
    }
}
