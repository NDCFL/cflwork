package top.cflwork.vo;

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
public class OucomeItemVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;

    @ApiModelProperty("支出明细编号")
    private Long id;
    @ApiModelProperty("支出编号")
    private Long outcomeId;
    @ApiModelProperty("科目编号")
    private String subjectName;
    @ApiModelProperty("时间")
    private Date time;
    @ApiModelProperty("金额")
    private Double money;

}
