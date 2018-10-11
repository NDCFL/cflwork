package top.cflwork.vo;

public class HouseEmployeeVo {
    private Long id;

    private Long companyId;

    private Long hotelId;

    private Long userId;

    public HouseEmployeeVo(Long id, Long companyId, Long hotelId, Long userId) {
        this.id = id;
        this.companyId = companyId;
        this.hotelId = hotelId;
        this.userId = userId;
    }

    public HouseEmployeeVo() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}