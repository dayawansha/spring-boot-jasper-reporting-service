package com.jasper.springbootjasperreportingservice.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class DATA_SERVICE_URI {

    @Autowired
    private static Environment environment;

    public static final String origin = environment.getProperty("jasper.report.origin");

    public  static final String baseURL = "/dataService/";


    public  static final String testReport = origin + baseURL + "testReport";


}
