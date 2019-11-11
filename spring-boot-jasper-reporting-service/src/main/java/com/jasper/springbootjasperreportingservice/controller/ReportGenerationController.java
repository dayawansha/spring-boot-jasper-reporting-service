package com.jasper.springbootjasperreportingservice.controller;

import com.jasper.springbootjasperreportingservice.dto.Response;
import com.jasper.springbootjasperreportingservice.dto.TestReport;
import com.jasper.springbootjasperreportingservice.service.ReportGenerationService;
import com.jasper.springbootjasperreportingservice.util.JasperCommonMethods;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportGenerationController {

    @Autowired
    private ReportGenerationService reportGenerationService;

    @Autowired
    private JasperCommonMethods jasperCommonMethods;

    private ResponseEntity responseEntity;
    private Response response;

    @CrossOrigin
    @PostMapping
    public ResponseEntity getTestReport(@RequestBody TestReport testReport) {

        response = reportGenerationService.getTestReport();
        responseEntity = jasperCommonMethods.getResponseEntity(response, testReport.getReportType());
        return responseEntity;
    }
}
