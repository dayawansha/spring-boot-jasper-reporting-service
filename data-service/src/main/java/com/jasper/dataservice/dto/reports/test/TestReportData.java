package com.jasper.dataservice.dto.reports.test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestReportData {
    private String reportType;

    private String stringValue;
    private Double doubleValue;

    private String[] stringArray;
    private Integer[] integerArray;

    private ArrayList<String> stringArrayList;
    private ArrayList<DataDto> dataDtoArrayListArrayList;

}
