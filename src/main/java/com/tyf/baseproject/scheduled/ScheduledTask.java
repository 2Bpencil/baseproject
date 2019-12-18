package com.tyf.baseproject.scheduled;


import com.tyf.baseproject.config.webSocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
* @Description:  定时任务
* @Author: Mr.Tan
* @Date: 2019/10/8 9:16
*/
@EnableScheduling
@Component
public class ScheduledTask {
    private final static Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private WebSocketServer webSocketServer;

    @Scheduled(fixedRate=2000)
    public void test(){


    }



}
