package top.cflwork.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 成本支出明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:29:58
 */
@Data
public class OutComeItemVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;

    @ApiModelProperty("支出明细编号")
    private Long id;
    @ApiModelProperty("支出编号")
    private Long outcomeId;
    @ApiModelProperty("科目名称")
    @Excel(name = "科目名称")
    private String subjectName;
    @ApiModelProperty("时间")
    @Excel(name = "时间")
    private Date time;
    @ApiModelProperty("金额")
    @Excel(name = "金额")
    private Double money;
    @ApiModelProperty("酒店编号")
    private Long hotelId;
    @ApiModelProperty(value = "业主编号",required = true)
    private Long masterId;
    @ApiModelProperty(value = "分页大小",required = true)
    private int pageSize;
    @ApiModelProperty(value = "起始页最小为1",required = true)
    private int pageIndex;
}
