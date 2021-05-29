/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.fzw.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * @author mr.24
 * @version Id: RestDemo, v 1.0 2018/11/22 下午11:17 Exp $$
 */
public class RestDemo {

    public static final String BASE_URI = "http://localhost:8080/myapp/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in my.restful package
        //final ResourceConfig rc = new ResourceConfig().packages("my.restful");


        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        //return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        return null;
    }
}
