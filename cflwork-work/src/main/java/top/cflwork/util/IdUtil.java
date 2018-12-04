package top.cflwork.util;

import com.twitter.snowflake.sequence.IdSequence;
import com.twitter.snowflake.support.SecondsIdSequenceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class IdUtil {
    private IdSequence idSequence;
    /**
     * 这里workerId暂时使用端口,如果服务部署在不同机子,端口万一被改成一样,那么计算出来的id有可能相同,这时候手动配置snowflake.workerId
     * snowflake.workerId的值必须大于0小于4194303
     */
    public IdUtil(@Value("${snowflake.workerId:-1}")long workerId, @Value("${server.port:9527}")long port) {
        idSequence=new SecondsIdSequenceFactory().create(workerId!=-1l?workerId:port);
    }

    public String nextId(){
        return idSequence.nextId() + "";
    }

    public String parse(String id){
        return idSequence.parse(Long.valueOf(id));
    }
}
