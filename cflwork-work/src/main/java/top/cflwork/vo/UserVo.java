package top.cflwork.vo;

import java.util.Date;

public class UserVo {
    private Long id;

    private String email;

    private String phone;

    private String accountName;

    private String password;

    private String nickname;

    private String identity;

    private String realname;

    private Byte gender;

    private Date birthday;

    private Integer age;

    private String address;

    private String qq;

    private String wechat;

    private String alipay;

    private String qqOpenid;

    private String weiboOpenid;

    private String wechatOpenid;

    private String headicon;

    private String description;

    private Date createTime;

    private Long companyId;

    private Byte isActive;

    private String hotelName;


    public UserVo(Long id, String email, String phone, String accountName, String password, String nickname, String identity, String realname, Byte gender, Date birthday, Integer age, String address, String qq, String wechat, String alipay, String qqOpenid, String weiboOpenid, String wechatOpenid, String headicon, String description, Date createTime, Long companyId, Byte isActive) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.accountName = accountName;
        this.password = password;
        this.nickname = nickname;
        this.identity = identity;
        this.realname = realname;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.wechat = wechat;
        this.alipay = alipay;
        this.qqOpenid = qqOpenid;
        this.weiboOpenid = weiboOpenid;
        this.wechatOpenid = wechatOpenid;
        this.headicon = headicon;
        this.description = description;
        this.createTime = createTime;
        this.companyId = companyId;
        this.isActive = isActive;
    }

    public UserVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public String getWeiboOpenid() {
        return weiboOpenid;
    }

    public void setWeiboOpenid(String weiboOpenid) {
        this.weiboOpenid = weiboOpenid == null ? null : weiboOpenid.trim();
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid == null ? null : wechatOpenid.trim();
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon == null ? null : headicon.trim();
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}