package com.convo_crew_project.convocrewproject.http;
import org.springframework.http.HttpStatusCode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class HttpResponse {

    private static HashMap<String, Object> response;

    public static HttpResponse success() {
        response = new HashMap<>();
        response.put("status", "success");
        response.put("code", HttpStatus.OK.value());
        return new HttpResponse();
    }

    public static HttpResponse error() {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.BAD_REQUEST.value());
        return new HttpResponse();
    }

    public HttpResponse withMessage(String message) {
        response.put("message", message);
        return this;
    }

//    public HttpResponse withCode(HttpStatus code) {
//        response.put("code", code.value());
//        return this;
//    }
//
//
    public HttpResponse withData(Object data) {
        response.put("data", data);
        return this;
    }

    public ResponseEntity<Object> build() {

        int code = (int) response.get("code");
        return new ResponseEntity<Object>(response, HttpStatusCode.valueOf(code));
    }


}
