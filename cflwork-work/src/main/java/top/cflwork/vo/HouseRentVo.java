package top.cflwork.vo;

import java.io.Serializable;

/**
 * Created by chenfeilong on 2017/12/26.
 */
public class HouseRentVo implements Serializable {

    private Integer houseTotal=0;//总房间数
    private Double dfPayMoney=0.0;//待付金额
    private Double monthPayMoney=0.0;//平均每月租金
    private Double houseMonthPayMoney=0.0;//每间每月
    private Double houseDayPayMoney=0.0;//每间，每天
    private Double chaoqiPayMoney=0.0;//超期未付
    private Double fiveDayPayMoney=0.0;//近5日待付
    private Double thisMonthPayMoney=0.0;//本月应付
    private Double thisMonthPayAll=0.0;//本月已付租金总额
    private Double thisMonthNotPay=0.0;//本月待付
    private Double nextMonthPay=0.0;//次月应付
    private Integer code;

    public Integer getHouseTotal() {
        return houseTotal;
    }

    public void setHouseTotal(Integer houseTotal) {
        this.houseTotal = houseTotal;
    }

    public Double getDfPayMoney() {
        return dfPayMoney;
    }

    public void setDfPayMoney(Double dfPayMoney) {
        this.dfPayMoney = dfPayMoney;
    }

    public Double getMonthPayMoney() {
        return monthPayMoney;
    }

    public void setMonthPayMoney(Double monthPayMoney) {
        this.monthPayMoney = monthPayMoney;
    }

    public Double getHouseMonthPayMoney() {
        return houseMonthPayMoney;
    }

    public void setHouseMonthPayMoney(Double houseMonthPayMoney) {
        this.houseMonthPayMoney = houseMonthPayMoney;
    }

    public Double getHouseDayPayMoney() {
        return houseDayPayMoney;
    }

    public void setHouseDayPayMoney(Double houseDayPayMoney) {
        this.houseDayPayMoney = houseDayPayMoney;
    }

    public Double getChaoqiPayMoney() {
        return chaoqiPayMoney;
    }

    public void setChaoqiPayMoney(Double chaoqiPayMoney) {
        this.chaoqiPayMoney = chaoqiPayMoney;
    }

    public Double getFiveDayPayMoney() {
        return fiveDayPayMoney;
    }

    public void setFiveDayPayMoney(Double fiveDayPayMoney) {
        this.fiveDayPayMoney = fiveDayPayMoney;
    }

    public Double getThisMonthPayMoney() {
        return thisMonthPayMoney;
    }

    public void setThisMonthPayMoney(Double thisMonthPayMoney) {
        this.thisMonthPayMoney = thisMonthPayMoney;
    }

    public Double getThisMonthPayAll() {
        return thisMonthPayAll;
    }

    public void setThisMonthPayAll(Double thisMonthPayAll) {
        this.thisMonthPayAll = thisMonthPayAll;
    }

    public Double getThisMonthNotPay() {
        return thisMonthNotPay;
    }

    public void setThisMonthNotPay(Double thisMonthNotPay) {
        this.thisMonthNotPay = thisMonthNotPay;
    }

    public Double getNextMonthPay() {
        return nextMonthPay;
    }

    public void setNextMonthPay(Double nextMonthPay) {
        this.nextMonthPay = nextMonthPay;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "HouseRentVo{" +
                "houseTotal=" + houseTotal +
                ", dfPayMoney=" + dfPayMoney +
                ", monthPayMoney=" + monthPayMoney +
                ", houseMonthPayMoney=" + houseMonthPayMoney +
                ", houseDayPayMoney=" + houseDayPayMoney +
                ", chaoqiPayMoney=" + chaoqiPayMoney +
                ", fiveDayPayMoney=" + fiveDayPayMoney +
                ", thisMonthPayMoney=" + thisMonthPayMoney +
                ", thisMonthPayAll=" + thisMonthPayAll +
                ", thisMonthNotPay=" + thisMonthNotPay +
                ", nextMonthPay=" + nextMonthPay +
                ", code=" + code +
                '}';
    }
}
