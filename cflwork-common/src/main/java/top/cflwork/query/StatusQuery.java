package top.cflwork.query;

/**
 * 状态查询对象，可用于更新指定记录的状态
 * 更新记录状态需要提供记录的主键id和status值
 * 创建于2017-08-23
 *
 * @author 陈飞龙
 * @version 1.0
 */
public class StatusQuery {

    private Long id;
    private Integer status;
    private Long companyId;
    private Long hotelId;
    private String cardTitle;
    private Long houseId;
    private String mobile;


    public StatusQuery() {}

    public StatusQuery(Long id, Integer status) {
        this.id = id;
        this.status = status;
    }

    public StatusQuery(Integer status, String mobile) {
        this.status = status;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public StatusQuery(Long id, Integer status, Long companyId, Long hotelId) {
        this.id = id;
        this.status = status;
        this.companyId = companyId;
        this.hotelId = hotelId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public StatusQuery(Integer status, Long hotelId, long houseId) {
        this.status = status;
        this.hotelId = hotelId;
        this.houseId = houseId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
