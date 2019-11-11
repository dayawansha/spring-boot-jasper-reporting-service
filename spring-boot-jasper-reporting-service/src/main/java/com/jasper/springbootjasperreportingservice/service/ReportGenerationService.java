package com.jasper.springbootjasperreportingservice.service;
import com.jasper.springbootjasperreportingservice.dto.Response;
import org.springframework.stereotype.Component;


@Component
public class ReportGenerationService {

    private Response response;

    public Response getTestReport() {

        return response;
    }

}
