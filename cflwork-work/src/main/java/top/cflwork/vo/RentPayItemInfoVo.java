package top.cflwork.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class RentPayItemInfoVo implements Serializable {
    @ApiModelProperty("酒店总收入")
    private Double hotelInSumMoney;
    @ApiModelProperty("酒店总支出")
    private Double hotelOutSumMoney;
    @ApiModelProperty(value = "当前业主总面积",dataType = "Integer")
    private Integer masterSumArea;//当前业主总面积
    @ApiModelProperty(value = "当前酒店总面积",dataType = "Integer")
    private Integer hotelSumArea;//当前总面积
    @ApiModelProperty(value = "分成比例",dataType = "Float")
    private Float rentPayScale;//分成比例

}
