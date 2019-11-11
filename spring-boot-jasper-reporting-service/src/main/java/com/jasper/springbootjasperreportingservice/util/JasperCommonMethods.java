package com.jasper.springbootjasperreportingservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.jasper.springbootjasperreportingservice.dto.Response;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by dushman on 11/11/19.
 */
@Component
public class JasperCommonMethods {

    private ByteArrayResource byteArrayResource;

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private Environment env;
    @Autowired
    private ObjectMapper objectMapper;

    private ResponseEntity responseEntity;


    /**
     * @param jrxmlFileName
     * @param jrBeanArrayDataSource
     * @param reportType
     * @return
     * @throws JRException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public ByteArrayResource reportGenarateMethode(String jrxmlFileName, JRBeanArrayDataSource jrBeanArrayDataSource, String reportType) throws JRException, ClassNotFoundException, IOException {

        Resource res = resourceLoader.getResource("classpath:" + jrxmlFileName);
        InputStream targetStream = res.getInputStream();

//        JasperReport jasperReport = JasperCompileManager.compileReport(targetStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(targetStream);
        HashMap<String, Object> nownParameeter = new HashMap<String, Object>();
        JasperPrint print = JasperFillManager.fillReport(jasperReport, nownParameeter, jrBeanArrayDataSource);
        File outDir = new File(env.getProperty("jasper.report.path"));
        outDir.mkdirs();

        // PDF Exportor.
        if (reportType.equals("pdf")) {

            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(print);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                    env.getProperty("jasper.report.path") + "/FirstJasperReport.pdf");

            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            byteArrayResource = fileToInputStreamConverterPDF();
            System.out.println("Done!");

        } else if (reportType.equals("xls")) {

            JRXlsxExporter exporter = new JRXlsxExporter();
            ExporterInput exporterInput = new SimpleExporterInput(print);
            exporter.setExporterInput(exporterInput);

            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                    env.getProperty("jasper.report.path") + "/FirstJasperReport.xls");

            exporter.setExporterOutput(exporterOutput);
            SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
            reportConfig.setSheetNames(new String[]{"sheet"});
            exporter.setConfiguration(reportConfig);
            exporter.exportReport();
            byteArrayResource = fileToInputStreamConverterExcel();
            System.out.println("Done!");
        }
        return byteArrayResource;
    }

    /**
     * @return
     * @throws IOException
     */
    private ByteArrayResource fileToInputStreamConverterPDF() throws IOException {

        ByteArrayResource resource;
        File filePdf = new File(env.getProperty("jasper.report.path") + "/FirstJasperReport.pdf");
        Path path = Paths.get(filePdf.getAbsolutePath());
        resource = new ByteArrayResource(Files.readAllBytes(path));
        return resource;
    }

    /**
     * @return
     * @throws IOException
     */
    private ByteArrayResource fileToInputStreamConverterExcel() throws IOException {

        ByteArrayResource resource;
        File filePdf = new File(env.getProperty("jasper.report.path") + "/FirstJasperReport.xls");
        Path path = Paths.get(filePdf.getAbsolutePath());
        resource = new ByteArrayResource(Files.readAllBytes(path));
        return resource;
    }

    /**
     * @param response
     * @param reportType
     * @return
     */
    public ResponseEntity getResponseEntity(Response response, String reportType) {
        HttpHeaders headers = new HttpHeaders();

        if (!reportType.equals("")) {

            if (response.getStatus() == Boolean.TRUE) {

                if (Objects.equals(reportType, "pdf")) {

                    responseEntity = ResponseEntity.ok()
                            .headers(headers)
                            .contentType(MediaType.parseMediaType("application/pdf"))
                            .body(response.getData());
                } else if (Objects.equals(reportType, "xls")) {

                    responseEntity = ResponseEntity.ok()
                            .header("Content-Disposition", "attachment; filename=" + "testXLS")
                            .contentType(MediaType.parseMediaType("application/csv"))
                            .body(response.getData());
                }
//                else {
//                    responseEntity = ResponseEntity.ok()
//                            .headers(headers)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .body("Invalid report type");
//                }
            } else {
                responseEntity = ResponseEntity.ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            }
        } else {
            responseEntity = ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Report type required");
        }
        return responseEntity;
    }



}
