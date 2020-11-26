package com.example.async.service.impl;

import com.example.async.service.LockService;
import com.example.async.service.LockAsyncService;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Semaphore;

@RequiredArgsConstructor
public class LockServiceImpl implements LockService {

    private final LockAsyncService lockAsyncService;
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void runOnceSameTimeOnDifferentThread() {
        if(semaphore.tryAcquire()) {
            lockAsyncService.test(semaphore::release);
        }
    }
}
