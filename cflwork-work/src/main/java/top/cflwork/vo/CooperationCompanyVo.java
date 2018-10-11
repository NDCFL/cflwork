package top.cflwork.vo;

import java.util.Date;

public class CooperationCompanyVo {
    private Long id;

    private Long companyId;

    private Long hotelId;

    private Long shopManagerId;

    private String name;

    private String address;

    private String contact;

    private String tel;

    private String phone;

    private String description;

    private Date createTime;

    private Byte isActive;

    private CompanyVo companyVo;

    private UserVo userVo;

    private HotelVo hotelVo;

    public CooperationCompanyVo(Long id, Long companyId, Long hotelId, Long shopManagerId, String name, String address, String contact, String tel, String phone, String description, Date createTime, Byte isActive) {
        this.id = id;
        this.companyId = companyId;
        this.hotelId = hotelId;
        this.shopManagerId = shopManagerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.tel = tel;
        this.phone = phone;
        this.description = description;
        this.createTime = createTime;
        this.isActive = isActive;
    }

    public CooperationCompanyVo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public HotelVo getHotelVo() {
        return hotelVo;
    }

    public void setHotelVo(HotelVo hotelVo) {
        this.hotelVo = hotelVo;
    }
}