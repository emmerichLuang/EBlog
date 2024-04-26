package com.ee.EBlog.core.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 系统初始化做的动作
 * @author: E.E.
 * @contact: emmerich@126.com
 * @date 2024-03-28
 * @desc:
 */
@Component
public class InitAction implements ApplicationRunner {


    private static final Logger logger = LoggerFactory.getLogger(InitAction.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动时候加载
        logger.info("init~~ ");


        // 系统关闭的钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                //关闭钩子
            }
        });
    }
}
