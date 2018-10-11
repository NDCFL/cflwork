package top.cflwork.query;

/**
 * 分页查询对象
 * 创建于2017-08-23
 *
 * @author 陈飞龙
 * @version 1.0
 */
public class PageQuery {

    private Integer pageNo;
    private Integer pageSize;
    private String searchVal;
    private Long userId;
    private Long hotelId;
    private Long companyId;
    private Integer startIndex;
    private Long houseId;
    private Integer type;
    private String dateVal;
    private Integer temp;

    public PageQuery() {
    }

    public PageQuery(String searchVal) {
        this.searchVal = searchVal;
    }
    public PageQuery(String searchVal,Long companyId) {
        this.searchVal = searchVal;
        this.companyId=companyId;
    }


    public PageQuery(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageQuery(Integer pageNo, Integer pageSize, String searchVal) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.searchVal = searchVal;
    }
    public PageQuery(Integer pageNo, Integer pageSize, String searchVal,Long companyId) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.searchVal = searchVal;
        this.companyId=companyId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchVal() {
        return searchVal;
    }

    public void setSearchVal(String searchVal) {
        this.searchVal = searchVal;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDateVal() {
        return dateVal;
    }

    public void setDateVal(String dateVal) {
        this.dateVal = dateVal;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}
