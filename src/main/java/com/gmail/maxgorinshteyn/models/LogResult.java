package com.gmail.maxgorinshteyn.models;

import java.util.LinkedList;
import java.util.List;


public class LogResult {

    private static LogResult logResult = new LogResult();

    private List<Element> listResults = new LinkedList();

    public void add(Element elem) {
        listResults.add(elem);
    }

    public static LogResult getInstance() {
        return logResult;
    }

    public List<Element> getListResults() {
        return listResults;
    }


}
