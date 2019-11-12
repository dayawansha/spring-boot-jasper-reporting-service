package com.jasper.springbootjasperreportingservice.util;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;

@Configuration
@PropertySource("classpath:application.properties")
public class DATA_SERVICE_URI {


    public  static final String baseURL = "/dataService/";

    public  static final String basicReport = baseURL + "basicReport";


}
