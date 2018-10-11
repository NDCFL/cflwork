package top.cflwork.listener;

import top.cflwork.common.SingletonConfigUtils;
import top.cflwork.constant.AppLoadConstants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用加载监听器，主要用途加载应用程序的基础配置信息
 * 创建于2017-08-15
 *
 * @author 陈飞龙
 * @version 1.0
 */
@WebListener
public class AppLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("init******");
        String appLoadConfig = servletContextEvent.getServletContext().getInitParameter(AppLoadConstants.CONFIG_LOCATION);
        SingletonConfigUtils config = SingletonConfigUtils.getInstance();
        config.build(appLoadConfig);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
