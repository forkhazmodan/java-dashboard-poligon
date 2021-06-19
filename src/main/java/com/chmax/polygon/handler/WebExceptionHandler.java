package com.chmax.polygon.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.chmax.polygon.controller")
public class WebExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
//        HttpStatus status = getStatus(request);
//        return new ResponseEntity<>(status);
//
//
//    }
//
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        HttpStatus status = HttpStatus.resolve(code);
//        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
//    }

}
