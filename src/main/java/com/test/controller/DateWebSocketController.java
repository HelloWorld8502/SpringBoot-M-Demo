package com.test.controller;

import com.test.task.WebSocketSendDateTask;
import com.test.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @description: webSocket控制器
 * @author: root
 * @date: 2021/8/17 9:22
 * @version: v1.0
 */
@Slf4j
@Component
@ServerEndpoint("/getDate")
public class DateWebSocketController {

    @OnOpen
    public void onOpen(Session session) {

        log.info("检测到新连接 SESSION ID:"+session.getId()+" SESSION:"+ session);
        WebSocketSendDateTask webSocketSendDateTask = SpringUtils.getBean(WebSocketSendDateTask.class);

        webSocketSendDateTask.executeSendDateTime(session);
        log.info("线程创建完毕");
    }

    @OnClose
    public void onClose(Session session) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("关闭WebSocket错误" + " SESSION ID:" + session.getId() + " SESSION:" + session + " 错误信息" + e.getMessage(), e);
        }
    }

    @OnError
    public void onError(Session session, Throwable err) {
        log.error("WebSocket Error :" + err.getMessage(), err);
        this.onClose(session);
    }

    @OnMessage
    public void onMessage(String msg,Session session) {
        log.info(msg);
        String fin = "1";
        if (fin.equals(msg)) {
            this.onClose(session);
        }


    }


    public static void asyncSendMsg(Session session, String msg)  {
        session.getAsyncRemote().sendText(msg);
    }
}
