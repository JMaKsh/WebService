package com.gmail.maxgorinshteyn.controller;

import com.gmail.maxgorinshteyn.models.Element;
import com.gmail.maxgorinshteyn.models.LogResult;
import com.gmail.maxgorinshteyn.service.Source;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("results")
public class LogResource {

    private LogResult logResult = LogResult.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Element> getFilteredLog(@QueryParam("path") String path) {
        Source source = new Source();
        source.getResultLog(path);
        return logResult.getListResults();
    }
}
