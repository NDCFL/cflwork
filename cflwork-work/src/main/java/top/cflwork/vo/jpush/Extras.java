package top.cflwork.vo.jpush;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 推送的额外字段,可继承使用
 * 须得和app定义好extras中各个字段的用途
 * 类型支持，Number String Boolean
 * type,0-测试推送
 *
 */
@Data
public class Extras {
    public static final Integer SCHOOL_BROADCAST=0;
    @NotNull
    private Integer type;
    private String id;
    private String json;
    public static Builder newBuilder(){
        return new Builder();
    }
    public static class Builder{
        private Extras extras;
        public Builder(){
            this.extras=new Extras();
        }
        public Builder setType(Integer type){
            this.extras.type=type;
            return this;
        }
        public Builder setId(String id){
            this.extras.id=id;
            return this;
        }
        //还有其他字段这里添加set方法
        public Builder setJSON(String json){
            this.extras.json=json;
            return this;
        }

        public Extras build(){
            return this.extras;
        }

    }

}
