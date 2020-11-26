package com.example.async.controller;


import com.example.async.dto.TestRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public interface TestController {

    @GetMapping("/test")
    String testRead();

    @PostMapping("/test")
    String test(@ModelAttribute TestRequest testRequest);
}
