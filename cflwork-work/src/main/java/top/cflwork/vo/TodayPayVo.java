package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

@Data
public class TodayPayVo implements Serializable {
    private Double inMoney;//今日的酒店总收入
    private Double outMoney;//今日的酒店总支出
    private Double nowInMoney;//业主当日营业额
    private Double nowOutMoney;//业主当日成本
    private Integer area;//当前业主总面积
    private Integer sumArea;//当前总面积
    private Float rentPayScale;//分成比例
    private Double nowPayMoney;//业主当日收益
    private Double allInMoney;//合同起的酒店总收入
    private Double allOutMoney;//合同起的酒店总支出
    private Double allNowInMoney;//业主总营业额
    private Double allNowOutMoney;//业主总支出
    private Double allNowPayMoney;//业主累计收入
    private Date startTime;//起始时间
    private Integer cnt;//房源套数
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
