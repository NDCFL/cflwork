package top.cflwork.vo;

import java.math.BigDecimal;
import java.util.Date;

public class LandlordVo {
    private Long id;

    private BigDecimal minProfit;

    private Double profitRate;

    private Date payDate;

    private String bankName;

    private String bankAccountName;

    private String bankAccountNo;

    public LandlordVo(Long id, BigDecimal minProfit, Double profitRate, Date payDate, String bankName, String bankAccountName, String bankAccountNo) {
        this.id = id;
        this.minProfit = minProfit;
        this.profitRate = profitRate;
        this.payDate = payDate;
        this.bankName = bankName;
        this.bankAccountName = bankAccountName;
        this.bankAccountNo = bankAccountNo;
    }

    public LandlordVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinProfit() {
        return minProfit;
    }

    public void setMinProfit(BigDecimal minProfit) {
        this.minProfit = minProfit;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Double profitRate) {
        this.profitRate = profitRate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo == null ? null : bankAccountNo.trim();
    }
}