package top.cflwork.vo;

import java.util.Date;

public class HotelVo {
    private Long id;

    private Long companyId;

    private Long hotelManagerId;

    private String title;

    private String tel;

    private Date createTime;

    private Date endTime;

    private Byte isActive;

    private String provice;

    private String city;

    private String town;

    private String address;

    private CompanyVo companyVo;

    private UserVo userVo;

    public HotelVo(Long id, Long companyId, Long hotelManagerId, String title, String tel, Date createTime, Byte isActive) {
        this.id = id;
        this.companyId = companyId;
        this.hotelManagerId = hotelManagerId;
        this.title = title;
        this.tel = tel;
        this.createTime = createTime;
        this.isActive = isActive;
    }

    public HotelVo() {
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


    public Long getHotelManagerId() {
        return hotelManagerId;
    }

    public void setHotelManagerId(Long hotelManagerId) {
        this.hotelManagerId = hotelManagerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    public CompanyVo getCompanyVo() {
        return companyVo;
    }

    public void setCompanyVo(CompanyVo companyVo) {
        this.companyVo = companyVo;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "HotelVo{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", hotelManagerId=" + hotelManagerId +
                ", title='" + title + '\'' +
                ", tel='" + tel + '\'' +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", isActive=" + isActive +
                ", companyVo=" + companyVo +
                ", userVo=" + userVo +
                '}';
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}