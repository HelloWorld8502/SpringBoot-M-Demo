package com.test.task;

import com.test.controller.DateWebSocketController;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @description: websocket发送任务线程池
 * @author: root
 * @date: 2021/8/17 9:56
 * @version: v1.0
 */
@Component
@Slf4j
public class WebSocketSendDateTask {





    @Async("webSocketSendTaskExecutor")
    public void executeSendDateTime(Session session){
        while (session.isOpen()) {
            log.info("SESSION 状态:" + session.isOpen());
            log.info("SESSION 安全状态:" + session.isSecure());
            DateWebSocketController.asyncSendMsg(session,new Date(System.currentTimeMillis()).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
