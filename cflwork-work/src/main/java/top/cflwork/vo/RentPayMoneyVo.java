package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 分成管理里面的成本统计模块
 */
@Data
public class RentPayMoneyVo implements Serializable {
    private String title;//科目名称
    private Double money;//金额
    private Date endTime;//周期结束时间
    private Date time1;//起始时间
    private Date time2;//终止时间
    private Long hotelId;//酒店编号
    private Date nowTime = new Date();
}
