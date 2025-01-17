package com.redhat.eap.microprofile;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/")
public class MyHelloWorld {

    @Inject
    MyHelloService myHelloService;

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    @Traced
    @Timed
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + myHelloService.createHelloMessage("JBoss EAP 7.4 with MicroProfile") + "\"}";
    }

    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    @Traced(false)
    @Counted
    public String getHelloWorldXML() {
        return "<xml><result>" + myHelloService.createHelloMessage("JBoss EAP 7.4 with MicroProfile") + "</result></xml>";
    }

}