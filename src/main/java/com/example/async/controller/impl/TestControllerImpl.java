package com.example.async.controller.impl;

import com.example.async.controller.TestController;
import com.example.async.dto.TestRequest;
import com.example.async.service.TestAsyncService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestControllerImpl implements TestController {

    private final TestAsyncService testAsyncService;

    @Override
    public String testRead() {
        testAsyncService.testRead();
        return "anything";
    }

    @Override
    public String test(TestRequest testRequest) {
        testAsyncService.testRead();
        return "anything";
    }
}
