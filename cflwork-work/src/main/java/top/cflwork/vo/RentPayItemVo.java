package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("分成房租付款明细")
    private Long id;
    @ApiModelProperty("分成房租编号")
    private Long rentPayId;
    @ApiModelProperty("约定付款起始时间")
    private Date payTime;
    @ApiModelProperty("实际付款时间")
    private Date realityPayTime;
    @ApiModelProperty("付款状态")
    private Byte isActive;
    @ApiModelProperty("本期成本支出")
    private Double outMoney;
    @ApiModelProperty("本期营业收入")
    private Double inMoney;
    @ApiModelProperty("支付金额")
    private Double payMoney;
    @ApiModelProperty("本期成本支出时间范围")
    private String outTime;
    @ApiModelProperty("本期营业收入时间范围")
    private String inTime;
    @ApiModelProperty("分成比例")
    private Float payProportion;
    @ApiModelProperty("备注")
    private String description;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("支付方式，有成本还是无成本")
    private Integer payType;
    @ApiModelProperty(value = "业主编号",required = true)
    private Long masterId;
    @ApiModelProperty("酒店编号")
    private Long hotelId;
    @ApiModelProperty("约定终止时间")
    private Date endTime;
    @ApiModelProperty("约定起始时间")
    private Date startTime;
    @ApiModelProperty(value = "分页大小",required = true)
    private int pageSize;
    @ApiModelProperty(value = "起始页最小为1",required = true)
    private int pageIndex;
    @ApiModelProperty(value = "订单明细生成状态")
    private Byte orderStatus;
}
