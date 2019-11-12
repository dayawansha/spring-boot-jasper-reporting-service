package com.jasper.dataservice.service;

import com.jasper.dataservice.dto.reports.basicReport.SubDataDto;
import com.jasper.dataservice.dto.reports.basicReport.BasicReportData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataService {

    public BasicReportData data(String reportType){

        BasicReportData basicReportData = new BasicReportData();
        basicReportData.setReportType(reportType);
        basicReportData.setStringValue("AAAAA");
        basicReportData.setDoubleValue(7777.77);


        String[] stringArray = {"Apple", "Banana", "Orange", "Grapes"};
        basicReportData.setStringArray(stringArray);

        Integer[] integerArray = {11111,2222,33333,44444,55555,66666,77777,8888,99999,0};
        basicReportData.setIntegerArray(integerArray);

        ArrayList<String> stringArrayList = new  ArrayList<String>();
        stringArrayList.add("test1");
        stringArrayList.add("test2");
        stringArrayList.add("test3");
        stringArrayList.add("test4");
        stringArrayList.add("test5");
        stringArrayList.add("test6");
        basicReportData.setStringArrayList(stringArrayList);



        SubDataDto subDataDto = new SubDataDto(1111,"aaaa",111.11,Boolean.TRUE);
        SubDataDto subDataDto2 = new SubDataDto(2222,"bbbb",222.22,Boolean.FALSE);
        SubDataDto subDataDto3 = new SubDataDto(3333,"cccc",333.33,Boolean.TRUE);
        SubDataDto subDataDto4 = new SubDataDto(4444,"dddd",444.44,Boolean.FALSE);
        SubDataDto subDataDto5 = new SubDataDto(5555,"eeee",222.22,Boolean.TRUE);
        SubDataDto subDataDto6 = new SubDataDto(6666,"ffff",222.22,Boolean.FALSE);
        SubDataDto subDataDto7 = new SubDataDto(7777,"gggg",222.22,Boolean.TRUE);
        SubDataDto subDataDto8 = new SubDataDto(8888,"hhhh",222.22,Boolean.FALSE);
        SubDataDto subDataDto9 = new SubDataDto(9999,"iiii",222.22,Boolean.TRUE);
        ArrayList<SubDataDto> subDataDtoArrayList = new ArrayList<>();
        subDataDtoArrayList.add(subDataDto);
        subDataDtoArrayList.add(subDataDto2);
        subDataDtoArrayList.add(subDataDto3);
        subDataDtoArrayList.add(subDataDto4);
        subDataDtoArrayList.add(subDataDto5);
        subDataDtoArrayList.add(subDataDto6);
        subDataDtoArrayList.add(subDataDto7);
        subDataDtoArrayList.add(subDataDto8);
        subDataDtoArrayList.add(subDataDto9);
        basicReportData.setSubDataDtoArrayListArrayList(subDataDtoArrayList);

        return basicReportData;
    }

}
