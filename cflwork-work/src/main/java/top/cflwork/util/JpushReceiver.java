package top.cflwork.util;

import com.xiaoleilu.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.cflwork.vo.jpush.Push;

import java.lang.reflect.InvocationTargetException;

@Component
public class JpushReceiver {
    @Autowired
    private Jpush jpush;
    public void sendPush(String pushJson){
        System.out.println(pushJson+"==============================");
        Push push = JSONUtil.toBean(pushJson, Push.class);
        try {
            jpush.sendPush(push);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}