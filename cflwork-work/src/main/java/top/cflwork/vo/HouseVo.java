package top.cflwork.vo;

import java.util.Date;

public class HouseVo {
    private Long id;

    private String cardTitle;

    private Byte type;

    private Long hotelId;

    private Byte houseStatus;

    private Date createTime;

    private Byte isActive;

    private String description;

    private HouseTypeVo houseTypeVo;

    private HotelVo hotelVo;

    private UserVo userVo;

    private Long houseType;

    private Date leaveTime;

    private Long companyId;


    public HouseVo(Long id, String cardTitle, Byte type, Long hotelId,  Byte houseStatus, Date createTime, Byte isActive, String description) {
        this.id = id;
        this.cardTitle = cardTitle;
        this.type = type;
        this.hotelId = hotelId;
        this.houseStatus = houseStatus;
        this.createTime = createTime;
        this.isActive = isActive;
        this.description = description;
    }

    public HouseVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle == null ? null : cardTitle.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Byte getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Byte houseStatus) {
        this.houseStatus = houseStatus;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public HouseTypeVo getHouseTypeVo() {
        return houseTypeVo;
    }

    public void setHouseTypeVo(HouseTypeVo houseTypeVo) {
        this.houseTypeVo = houseTypeVo;
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

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Long getHouseType() {
        return houseType;
    }

    public void setHouseType(Long houseType) {
        this.houseType = houseType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}