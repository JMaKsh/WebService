package com.gmail.maxgorinshteyn.service;

import com.gmail.maxgorinshteyn.models.Element;
import com.gmail.maxgorinshteyn.models.LogResult;
import com.gmail.maxgorinshteyn.models.SdlSigElement;
import com.gmail.maxgorinshteyn.models.StoppingElement;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Source {

    private LogResult logResult = LogResult.getInstance();

    public void getResultLog(String path) {
        logResult.getListResults().clear();
        try {
            File file = new File(path);
            try (FileReader fr = new FileReader(file);) {
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    Element element = getElementByRegex(line);
                    if (element != null)
                        logResult.add(element);
                    line = reader.readLine();
                }
                reader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Element getElementByRegex(String line) {
        Element element = null;
        Pattern re = Pattern.compile("(\\|SdlSig\\s+\\|)", Pattern.CASE_INSENSITIVE);
        Matcher m = re.matcher(line);
        if (m.find()) {
            String[] lines = line.split(" +\\|");
            element = new SdlSigElement(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], lines[8]);
        } else {
            re = Pattern.compile("(\\|Stopping\\s+\\|)", Pattern.CASE_INSENSITIVE);
            m = re.matcher(line);
            if (m.find()) {
                String[] lines = line.split(" +\\|");
                element = new StoppingElement(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], lines[8]);
            }
        }
        return element;
    }
}

