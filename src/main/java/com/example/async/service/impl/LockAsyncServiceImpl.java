package com.example.async.service.impl;

import com.example.async.service.LockAsyncService;

public class LockAsyncServiceImpl implements LockAsyncService {

    @Override
    public void test(Runnable runnable) {
        try {
            System.out.println("Do something");
        } finally {
            runnable.run();
        }
    }
}
