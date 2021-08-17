package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @description: 自定义线程池配置
 * @author: root
 * @date: 2021/8/17 9:01
 * @version: v1.0
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * webSocket数据发送任务线程池
     * @return
     */
    @Bean
    public Executor webSocketSendTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(32);
        executor.setMaxPoolSize(256);
        executor.setQueueCapacity(512);
        executor.setKeepAliveSeconds(0);
        executor.setThreadNamePrefix("webSocketSendTaskExecutor");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}
