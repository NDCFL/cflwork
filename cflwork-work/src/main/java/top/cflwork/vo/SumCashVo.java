package top.cflwork.vo;

import java.io.Serializable;

/**
 * Created by chenfeilong on 2018/1/7.
 */
public class SumCashVo implements Serializable {

    private Double sumMoneyIn=0.0;
    private Double sumMoneyOut=0.0;
    private Double sumMoneyJieyu=0.0;
    private String payTypeName;

    public Double getSumMoneyIn() {
        return sumMoneyIn;
    }

    public void setSumMoneyIn(Double sumMoneyIn) {
        this.sumMoneyIn = sumMoneyIn;
    }

    public Double getSumMoneyOut() {
        return sumMoneyOut;
    }

    public void setSumMoneyOut(Double sumMoneyOut) {
        this.sumMoneyOut = sumMoneyOut;
    }

    public Double getSumMoneyJieyu() {
        return sumMoneyIn-sumMoneyOut;
    }

    public void setSumMoneyJieyu(Double sumMoneyJieyu) {
        this.sumMoneyJieyu = sumMoneyJieyu;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
