package com.jasper.dataservice.service;

import com.jasper.dataservice.dto.reports.basicReport.DataDto;
import com.jasper.dataservice.dto.reports.basicReport.TestReportData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataService {

    public TestReportData data(String reportType){

        TestReportData testReportData = new TestReportData();
        testReportData.setReportType(reportType);
        testReportData.setStringValue("AAAAA");
        testReportData.setDoubleValue(7777.77);


        String[] stringArray = {"Apple", "Banana", "Orange", "Grapes"};
        testReportData.setStringArray(stringArray);

        Integer[] integerArray = {11111,2222,33333,44444,55555,66666,77777,8888,99999,0};
        testReportData.setIntegerArray(integerArray);

        ArrayList<String> stringArrayList = new  ArrayList<String>();
        stringArrayList.add("test1");
        stringArrayList.add("test2");
        stringArrayList.add("test3");
        stringArrayList.add("test4");
        stringArrayList.add("test5");
        stringArrayList.add("test6");
        testReportData.setStringArrayList(stringArrayList);



        DataDto dataDto = new DataDto(1111,"aaaa",111.11,Boolean.TRUE);
        DataDto dataDto2 = new DataDto(2222,"bbbb",222.22,Boolean.FALSE);
        DataDto dataDto3 = new DataDto(3333,"cccc",333.33,Boolean.TRUE);
        DataDto dataDto4 = new DataDto(4444,"dddd",444.44,Boolean.FALSE);
        DataDto dataDto5 = new DataDto(5555,"eeee",222.22,Boolean.TRUE);
        DataDto dataDto6 = new DataDto(6666,"ffff",222.22,Boolean.FALSE);
        DataDto dataDto7 = new DataDto(7777,"gggg",222.22,Boolean.TRUE);
        DataDto dataDto8 = new DataDto(8888,"hhhh",222.22,Boolean.FALSE);
        DataDto dataDto9 = new DataDto(9999,"iiii",222.22,Boolean.TRUE);
        ArrayList<DataDto> dataDtoArrayList = new ArrayList<>();
        dataDtoArrayList.add(dataDto);
        dataDtoArrayList.add(dataDto2);
        dataDtoArrayList.add(dataDto3);
        dataDtoArrayList.add(dataDto4);
        dataDtoArrayList.add(dataDto5);
        dataDtoArrayList.add(dataDto6);
        dataDtoArrayList.add(dataDto7);
        dataDtoArrayList.add(dataDto8);
        dataDtoArrayList.add(dataDto9);
        testReportData.setDataDtoArrayListArrayList(dataDtoArrayList);

        return testReportData;
    }

}
