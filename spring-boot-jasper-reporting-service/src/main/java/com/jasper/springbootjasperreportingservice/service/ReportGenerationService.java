package com.jasper.springbootjasperreportingservice.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasper.springbootjasperreportingservice.dto.Response;
import com.jasper.springbootjasperreportingservice.dto.reports.basicReport.BasicReportData;
import com.jasper.springbootjasperreportingservice.dto.reports.basicReport.TestReportRequest;
import com.jasper.springbootjasperreportingservice.util.DATA_SERVICE_URI;
import com.jasper.springbootjasperreportingservice.util.InfoLogger;
import com.jasper.springbootjasperreportingservice.util.JasperCommonMethods;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


@Component
public class ReportGenerationService  extends InfoLogger {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private Environment env;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JasperCommonMethods jasperCommonMethods;

    private JRBeanArrayDataSource jrBeanArrayDataSource;

    private ByteArrayResource byteArrayResource;

    private Response response;

    public Response getTestReport(TestReportRequest testReportRequest) {

        String jrxmlFileName = "jrxmls/testReport";

        if (!Objects.equals(testReportRequest.getReportType(), "")) {

            try {

                HashMap<String, ?> dataMap = jasperCommonMethods.getDataApiCall(testReportRequest, DATA_SERVICE_URI.testReport, "agentOrigin");

                BasicReportData intimationReportDTO = objectMapper.convertValue(dataMap, BasicReportData.class);

                JRBeanArrayDataSource jrBeanArrayDataSource = new JRBeanArrayDataSource(new BasicReportData[]{intimationReportDTO});

                byteArrayResource = jasperCommonMethods.reportGenarateMethode(jrxmlFileName, jrBeanArrayDataSource, testReportRequest.getReportType());


                response = new Response(1, TRUE, "sucess", byteArrayResource);

            } catch (JRException | ClassNotFoundException | IOException e) {
                LOGGER.error("Technical failure", e);
                response = new Response(3, FALSE, "Technical failure", "");
            } catch (NullPointerException e) {
                LOGGER.error("No data to generate the Report", e);
                response = new Response(2, FALSE, "No data to generate the Report", "");
            } catch (ResourceAccessException e) {
                LOGGER.error("Connection refused with Data Access Service", e);
                response = new Response(2, FALSE, "Connection refused with Data Access Service", "");
            } catch (Exception e) {
                LOGGER.error("Technical failure", e);
                response = new Response(3, FALSE, "Technical failure", "");
            }
        } else {
            response = new Response(2, FALSE, "Null input values", "");
        }

        return response;
    }



}
