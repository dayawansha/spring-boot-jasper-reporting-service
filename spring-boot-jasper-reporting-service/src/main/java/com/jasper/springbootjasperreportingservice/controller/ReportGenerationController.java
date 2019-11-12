package com.jasper.springbootjasperreportingservice.controller;

import com.jasper.springbootjasperreportingservice.dto.Response;
import com.jasper.springbootjasperreportingservice.dto.reports.basicReport.TestReportRequest;
import com.jasper.springbootjasperreportingservice.service.ReportGenerationService;
import com.jasper.springbootjasperreportingservice.util.JasperCommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports/")
public class ReportGenerationController {

    @Autowired
    private ReportGenerationService reportGenerationService;

    @Autowired
    private JasperCommonMethods jasperCommonMethods;

    private ResponseEntity responseEntity;
    private Response response;

    @CrossOrigin
    @GetMapping(value = "basicReport")
    public ResponseEntity getTestReport(@RequestParam String reportType) {

        response = reportGenerationService.getTestReport(reportType);
        responseEntity = jasperCommonMethods.getResponseEntity(response, reportType);
        return responseEntity;
    }
}
