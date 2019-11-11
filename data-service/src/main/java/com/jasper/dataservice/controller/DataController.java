package com.jasper.dataservice.controller;


import com.jasper.dataservice.dto.reports.test.TestReportData;
import com.jasper.dataservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataService")
public class DataController {

    @Autowired
    private DataService dataService;


    @GetMapping
    public ResponseEntity<TestReportData> getAllUserIdentities(@RequestParam(value = "reportType") String reportType)  {
        TestReportData commonResponse = dataService.data(reportType);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
