package top.cflwork.job;

import org.springframework.stereotype.Component;

/**
 * quartz job示例，使用方法调用形式<br />
 * 创建于2017-09-22
 *
 * @author 陈飞龙
 * @version 1.0
 *
 */
@Component
public class HelloJob {

    public void run() {
        System.out.println("hello!");
    }
}
