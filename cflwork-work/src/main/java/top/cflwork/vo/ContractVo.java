package top.cflwork.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ContractVo {
    private Long id;

    private Long masterId;

    private Long companyId;

    private String contractContract;

    private Integer contractYears;

    private Date contractDate;

    private String contractNo;

    private BigDecimal minProfit;

    private Double profitRate;

    private BigDecimal monthPay;

    private Date payDate;

    private Date createTime;

    private Byte isActive;

    private ContractMasterVo contractMasterVo;


    public ContractVo(Long id, Long masterId, Long companyId, String contractContract, Integer contractYears, Date contractDate, String contractNo, BigDecimal minProfit, Double profitRate, BigDecimal monthPay, Date payDate, Date createTime, Byte isActive) {
        this.id = id;
        this.masterId = masterId;
        this.companyId = companyId;
        this.contractContract = contractContract;
        this.contractYears = contractYears;
        this.contractDate = contractDate;
        this.contractNo = contractNo;
        this.minProfit = minProfit;
        this.profitRate = profitRate;
        this.monthPay = monthPay;
        this.payDate = payDate;
        this.createTime = createTime;
        this.isActive = isActive;
    }

    public ContractVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getContractContract() {
        return contractContract;
    }

    public void setContractContract(String contractContract) {
        this.contractContract = contractContract == null ? null : contractContract.trim();
    }

    public Integer getContractYears() {
        return contractYears;
    }

    public void setContractYears(Integer contractYears) {
        this.contractYears = contractYears;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
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

    public BigDecimal getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(BigDecimal monthPay) {
        this.monthPay = monthPay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public ContractMasterVo getContractMasterVo() {
        return contractMasterVo;
    }

    public void setContractMasterVo(ContractMasterVo contractMasterVo) {
        this.contractMasterVo = contractMasterVo;
    }
}