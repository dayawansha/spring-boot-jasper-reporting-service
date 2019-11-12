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

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public Integer[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(Integer[] integerArray) {
        this.integerArray = integerArray;
    }

    public ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public void setStringArrayList(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public ArrayList<SubDataDto> getSubDataDtoArrayListArrayList() {
        return subDataDtoArrayListArrayList;
    }

    public void setSubDataDtoArrayListArrayList(ArrayList<SubDataDto> subDataDtoArrayListArrayList) {
        this.subDataDtoArrayListArrayList = subDataDtoArrayListArrayList;
    }
}
