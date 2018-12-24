package top.cflwork.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

@Data
public class TodayPayVo implements Serializable {
    @ApiModelProperty(value = "今日的酒店总收入--当日营业额",dataType = "Double")
    private Double inMoney;//今日的酒店总收入
    @ApiModelProperty(value = "今日的酒店总支出",dataType = "Double")
    private Double outMoney;//今日的酒店总支出
    @ApiModelProperty(value = "业主当日营业额",dataType = "Double")
    private Double nowInMoney;//业主当日营业额
    @ApiModelProperty(value = "业主当日成本",dataType = "Double")
    private Double nowOutMoney;//业主当日成本
    @ApiModelProperty(value = "当前业主总面积--合计面积",dataType = "Integer")
    private Integer area;//当前业主总面积
    @ApiModelProperty(value = "当前总面积",dataType = "Integer")
    private Integer sumArea;//当前总面积
    @ApiModelProperty(value = "分成比例",dataType = "Float")
    private Float rentPayScale;//分成比例
    @ApiModelProperty(value = "业主当日收益--当日收益",dataType = "Double")
    private Double nowPayMoney;//业主当日收益
    @ApiModelProperty(value = "合同起的酒店总收入",dataType = "Double")
    private Double allInMoney;//合同起的酒店总收入
    @ApiModelProperty(value = "合同起的酒店总支出",dataType = "Double")
    private Double allOutMoney;//合同起的酒店总支出
    @ApiModelProperty(value = "业主总营业额",dataType = "Double")
    private Double allNowInMoney;//业主总营业额
    @ApiModelProperty(value = "业主总支出",dataType = "Double")
    private Double allNowOutMoney;//业主总支出
    @ApiModelProperty(value = "业主累计收入",dataType = "Double")
    private Double allNowPayMoney;//业主累计收入
    @ApiModelProperty(value = "起始时间",dataType = "Double")
    private Date startTime;//起始时间
    @ApiModelProperty(value = "房源套数--房源",dataType = "Integer")
    private Integer cnt;//房源套数
    @ApiModelProperty(value = "当前查询的时间",dataType = "String")
    private String nowTime;//当前查询的时间
    /**
     * <==    Columns: inMoney, outMoney, allInMoney, allOutMoney, area, sumArea, rentPayScale, startTime
     <==        Row: 88322.00, 69644.00, 88322.00, 69644.00, 820, 30, 0.15, 2018-09-27
     <==      Total: 1
     * @return
     */
    //当日营业额:总营业额/总面积*业主总面积
    public Double getNowInMoney() {
        return formatDouble(inMoney/sumArea*area);
    }

    //当日成本:总成本/总面积*业主总面积
    public Double getNowOutMoney() {
        return formatDouble(outMoney/sumArea*area);
    }

    public Double getNowPayMoney() {
        /**
         * （当日营业额-当日成本）*分成比例
         * 当日营业额:总营业额/总面积*业主总面积
         * 当日成本:总成本/总面积*业主总面积
         */
        return formatDouble((inMoney-outMoney)/sumArea*area*rentPayScale);
    }

    public Double getAllNowPayMoney() {
        return formatDouble((allInMoney-allOutMoney)/sumArea*area*rentPayScale);
    }

    public Double getAllNowInMoney() {
        return formatDouble(allInMoney/sumArea*area);
    }

    public Double getAllNowOutMoney() {
        return formatDouble(allOutMoney/sumArea*area);
    }
    public Double formatDouble(Double num){
        DecimalFormat df=new DecimalFormat("#.00");
        return Double.parseDouble(df.format(num));
    }
}
