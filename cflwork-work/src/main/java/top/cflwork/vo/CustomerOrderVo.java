package top.cflwork.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerOrderVo {
    private Long id;

    private Long companyId;

    private Long hotelId;

    private Long shopManagerId;

    private Long houseId;

    private Long contractId;

    private String customerName;

    private String customerIdentity;

    private String customerPhone;

    private String customerGender;

    private Byte customerFrom;

    private Long websiteId;

    private BigDecimal unitPrice;

    private Byte totalDays;

    private BigDecimal housePay;

    private BigDecimal servicePay;

    private BigDecimal deposit;

    private BigDecimal totalPay;

    private BigDecimal actualReturn;

    private Long paymentTypeId;

    private Date checkinTime;

    private Date checkoutTime;

    private Date checkoutMaxTime;

    private String remark;

    private Byte orderStatus;

    private Date createTime;

    private Byte isCheck;

    private String checkRemark;

    private Byte isActive;

    private Long hander;

    private String hand;

    private CompanyVo companyVo;//公司

    private HotelVo hotelVo;//酒店

    private UserVo userVo;//店长

    private HouseVo houseVo;//房号

    private ContractVo contractVo;//签约地块

    private CooperationWebsiteVo cooperationWebsiteVo;//OTA网站

    private PaymentTypeVo paymentTypeVo;//支付类型

    private String web;

    private String pay;

    private Byte isCash;//是否结算

    private Long otherHotel;//往来商家编号

    private BigDecimal otherHotelMoney;//结算金额

    private Long otherHotelMoneyType;//结算支付方式

    private Integer type;

    private Integer typeId;

    private Long newHotelId;



    public CustomerOrderVo(Long id, Long companyId, Long hotelId, Long shopManagerId, Long houseId, Long contractId, String customerName, String customerIdentity, String customerPhone, String customerGender, Byte customerFrom, Long websiteId, BigDecimal unitPrice, Byte totalDays, BigDecimal housePay, BigDecimal servicePay, BigDecimal deposit, BigDecimal totalPay, BigDecimal actualReturn, Long paymentTypeId, Date checkinTime, Date checkoutTime, Date checkoutMaxTime, String remark, Byte orderStatus, Date createTime, Byte isCheck, String checkRemark, Byte isActive) {
        this.id = id;
        this.companyId = companyId;
        this.hotelId = hotelId;
        this.shopManagerId = shopManagerId;
        this.houseId = houseId;
        this.contractId = contractId;
        this.customerName = customerName;
        this.customerIdentity = customerIdentity;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerFrom = customerFrom;
        this.websiteId = websiteId;
        this.unitPrice = unitPrice;
        this.totalDays = totalDays;
        this.housePay = housePay;
        this.servicePay = servicePay;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.actualReturn = actualReturn;
        this.paymentTypeId = paymentTypeId;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.checkoutMaxTime = checkoutMaxTime;
        this.remark = remark;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.isCheck = isCheck;
        this.checkRemark = checkRemark;
        this.isActive = isActive;
    }

    public CustomerOrderVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getShopManagerId() {
        return shopManagerId;
    }

    public void setShopManagerId(Long shopManagerId) {
        this.shopManagerId = shopManagerId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity == null ? null : customerIdentity.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender == null ? null : customerGender.trim();
    }

    public Byte getCustomerFrom() {
        return customerFrom;
    }

    public void setCustomerFrom(Byte customerFrom) {
        this.customerFrom = customerFrom;
    }

    public Long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Long websiteId) {
        this.websiteId = websiteId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Byte getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Byte totalDays) {
        this.totalDays = totalDays;
    }

    public BigDecimal getHousePay() {
        return housePay;
    }

    public void setHousePay(BigDecimal housePay) {
        this.housePay = housePay;
    }

    public BigDecimal getServicePay() {
        return servicePay;
    }

    public void setServicePay(BigDecimal servicePay) {
        this.servicePay = servicePay;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public BigDecimal getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(BigDecimal actualReturn) {
        this.actualReturn = actualReturn;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Date getCheckoutMaxTime() {
        return checkoutMaxTime;
    }

    public void setCheckoutMaxTime(Date checkoutMaxTime) {
        this.checkoutMaxTime = checkoutMaxTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public CompanyVo getCompanyVo() {
        return companyVo;
    }

    public void setCompanyVo(CompanyVo companyVo) {
        this.companyVo = companyVo;
    }

    public HotelVo getHotelVo() {
        return hotelVo;
    }

    public void setHotelVo(HotelVo hotelVo) {
        this.hotelVo = hotelVo;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public HouseVo getHouseVo() {
        return houseVo;
    }

    public void setHouseVo(HouseVo houseVo) {
        this.houseVo = houseVo;
    }

    public ContractVo getContractVo() {
        return contractVo;
    }

    public void setContractVo(ContractVo contractVo) {
        this.contractVo = contractVo;
    }

    public CooperationWebsiteVo getCooperationWebsiteVo() {
        return cooperationWebsiteVo;
    }

    public void setCooperationWebsiteVo(CooperationWebsiteVo cooperationWebsiteVo) {
        this.cooperationWebsiteVo = cooperationWebsiteVo;
    }

    public PaymentTypeVo getPaymentTypeVo() {
        return paymentTypeVo;
    }

    public void setPaymentTypeVo(PaymentTypeVo paymentTypeVo) {
        this.paymentTypeVo = paymentTypeVo;
    }

    public Long getHander() {
        return hander;
    }

    public void setHander(Long hander) {
        this.hander = hander;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Byte getIsCash() {
        return isCash;
    }

    public void setIsCash(Byte isCash) {
        this.isCash = isCash;
    }

    public Long getOtherHotel() {
        return otherHotel;
    }

    public void setOtherHotel(Long otherHotel) {
        this.otherHotel = otherHotel;
    }

    public BigDecimal getOtherHotelMoney() {
        return otherHotelMoney;
    }

    public void setOtherHotelMoney(BigDecimal otherHotelMoney) {
        this.otherHotelMoney = otherHotelMoney;
    }

    public Long getOtherHotelMoneyType() {
        return otherHotelMoneyType;
    }

    public void setOtherHotelMoneyType(Long otherHotelMoneyType) {
        this.otherHotelMoneyType = otherHotelMoneyType;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getNewHotelId() {
        return newHotelId;
    }

    public void setNewHotelId(Long newHotelId) {
        this.newHotelId = newHotelId;
    }
}