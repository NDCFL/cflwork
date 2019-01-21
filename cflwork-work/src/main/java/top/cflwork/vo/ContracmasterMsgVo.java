package top.cflwork.vo;

import com.xiaoleilu.hutool.date.DateUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 业主消息表，用于给业主发送消息
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2018-11-21 10:06:20
 */
@Data
public class ContracmasterMsgVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;
    //业主消息编号
    private Long id;
    //业主编号
    private Long masterId;
    //发送者编号
    private Long sendId;
    //消息标题
    private String name;
    //消息内容
    private String content;
    //创建时间
    private Date createTime;
    //状态,0：已读状态，1：未读状态
    private Byte isActive;
    //关联业主
    private String contractMasterName;
    //关联当前用户
    private String sendName;
}
