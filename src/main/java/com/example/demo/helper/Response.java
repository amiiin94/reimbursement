package com.example.demo.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<Object> generate(Object data, String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("status", status.value());

        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> generate(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", status.value());

        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> generate(Object data, String message) {
        return generate(data, message, HttpStatus.OK);
    }

    public static ResponseEntity<Object> generate(String message) {
        return generate(message, HttpStatus.OK);
    }
}
