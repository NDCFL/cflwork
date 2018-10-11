package top.cflwork.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LogVo {
    //编号
    private Long id;
    //用户编号
    private Long userId;
    //用户名称
    private String username;
    //描述
    private String operation;
    //
    private Integer time;

    private String method;

    private String params;

    private String ip;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    private Date createTime;
}
