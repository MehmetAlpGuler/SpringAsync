package com.example.async.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import static com.example.async.config.ThreadPoolConstants.THREAD_POOL_TASK_EXECUTOR;
import static com.example.async.config.ThreadPoolConstants.THREAD_POOL_TASK_EXECUTOR1;

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

    @Bean(name = THREAD_POOL_TASK_EXECUTOR)
    public Executor threadPoolTaskExecutor() {
        return createThreadPoolTaskExecutor(THREAD_POOL_TASK_EXECUTOR);
    }

    @Bean(name = THREAD_POOL_TASK_EXECUTOR1)
    public Executor threadPoolTaskExecutor1() {
        return createThreadPoolTaskExecutor(THREAD_POOL_TASK_EXECUTOR1);
    }

    @Override
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }

    private static TaskExecutor createThreadPoolTaskExecutor(String name) {
        var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(400);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix(name + "-");
        executor.initialize();
        //log.info("{} initialized by queue max pool size: {}", name, executor.getPoolSize());
        return executor;
    }
}