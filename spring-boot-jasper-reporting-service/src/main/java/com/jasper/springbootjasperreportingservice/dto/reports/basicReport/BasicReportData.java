package com.jasper.springbootjasperreportingservice.dto.reports.basicReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicReportData {
    private String reportType;

    private String stringValue;
    private Double doubleValue;

    private String[] stringArray;
    private Integer[] integerArray;

    private ArrayList<String> stringArrayList;
    private ArrayList<SubDataDto> subDataDtoArrayListArrayList;
}
