package com.example.async.controller.impl;

import com.example.async.controller.LockContoller;
import com.example.async.service.LockService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LockContollerImpl implements LockContoller {

    private final LockService lockService;

    @Override
    public String runOnceSameTimeOnDifferentThread() {
        lockService.runOnceSameTimeOnDifferentThread();
        return "something";
    }
}
