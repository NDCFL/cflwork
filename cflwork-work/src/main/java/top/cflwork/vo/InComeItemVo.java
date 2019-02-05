package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 收入明细
 *
 * @author cflwork
 * @email xljx_888888@163.com
 * @date 2019-01-31 10:37:31
 */
@Data
public class InComeItemVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;

    @ApiModelProperty("收入明细编号")
    private Long id;
    @ApiModelProperty("收入编号")
    private Long incomeId;
    @ApiModelProperty("科目名称")
    private String subjectName;
    @ApiModelProperty("时间")
    private Date time;
    @ApiModelProperty("金额")
    private Double money;
    @ApiModelProperty("酒店编号")
    private Long hotelId;


}
