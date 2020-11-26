package com.example.async.service.impl;

import com.example.async.service.TestAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.async.config.ThreadPoolConstants.THREAD_POOL_TASK_EXECUTOR;

@Service
public class TestAsyncServiceImpl implements TestAsyncService {

    @Override
    @Transactional
    @Async(THREAD_POOL_TASK_EXECUTOR)
    public void test() {
        System.out.println("test");
    }

    @Override
    @Transactional(readOnly = true)
    @Async(THREAD_POOL_TASK_EXECUTOR)
    public void testRead() {
        System.out.println("test");
    }
}
