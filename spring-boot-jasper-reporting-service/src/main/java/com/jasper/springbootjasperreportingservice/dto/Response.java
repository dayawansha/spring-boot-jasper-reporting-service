package com.jasper.springbootjasperreportingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer code;
    private Boolean status;
    private String message;
    private Object data;

}

