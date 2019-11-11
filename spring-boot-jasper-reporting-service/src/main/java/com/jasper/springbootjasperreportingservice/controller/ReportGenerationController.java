package com.jasper.springbootjasperreportingservice.controller;

import com.jasper.springbootjasperreportingservice.dto.Response;
import com.jasper.springbootjasperreportingservice.dto.reports.test.TestReportRequest;
import com.jasper.springbootjasperreportingservice.service.ReportGenerationService;
import com.jasper.springbootjasperreportingservice.util.JasperCommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getTestReport(@RequestBody TestReportRequest testReportRequest) {

        response = reportGenerationService.getTestReport(testReportRequest);
        responseEntity = jasperCommonMethods.getResponseEntity(response, testReportRequest.getReportType());
        return responseEntity;
    }
}
