package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 分成房租，每个合同每期分成明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-02-01 14:09:41
 */
@Data
public class RentPayItemVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;

    //分成房租付款明细
    private Long id;
    //分成房租编号
    private Long rentPayId;
    //约定付款时间
    private Date payTime;
    //实际付款时间
    private Date realityPayTime;
    //付款状态
    private Byte isActive;
    //本期成本支出
    private Double outMoney;
    //本期营业收入
    private Double inMoney;
    //支付金额
    private Double payMoney;
    //本期成本支出时间范围
    private String outTime;
    //本期营业收入时间范围
    private String inTime;
    //分成比例
    private Float payProportion;
    //备注
    private String description;
    //创建时间
    private Date createTime;
    //支付方式，有成本还是无成本
    private Integer payType;
    //业主编号
    private Long masterId;
    //酒店编号
    private Long hotelId;
    private Date startTime;
    private Date endTime;


}
