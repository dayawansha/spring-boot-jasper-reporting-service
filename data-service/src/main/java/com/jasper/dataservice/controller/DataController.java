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
    public ResponseEntity<TestReportData> getAllUserIdentities(@RequestParam(value = "username") String username)  {
//    public ResponseEntity<TestReportData> getAllUserIdentities()  {
        TestReportData commonResponse = dataService.data(username);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
