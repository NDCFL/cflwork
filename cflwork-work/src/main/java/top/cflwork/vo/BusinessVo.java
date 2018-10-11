package top.cflwork.vo;


import java.io.Serializable;

public class BusinessVo implements Serializable {
    private Integer sumHotel=0;
    private Double sumPrice=0.0d;
    private Integer countBusincess=0;
    private String times;
    private Integer sumHotels=0;
    private Double sumPrices=0.0d;
    private Integer countBusincesss=0;
    private String hotelName;
    private Long hotelTypeId;
    private String faceImg;
    private Long types;
    private Long id;
    public Integer getSumHotel() {
        return sumHotel;
    }

    public void setSumHotel(Integer sumHotel) {
        this.sumHotel = sumHotel;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getCountBusincess() {
        return countBusincess;
    }

    public void setCountBusincess(Integer countBusincess) {
        this.countBusincess = countBusincess;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getSumHotels() {
        return sumHotels;
    }

    public void setSumHotels(Integer sumHotels) {
        this.sumHotels = sumHotels;
    }

    public Double getSumPrices() {
        return sumPrices;
    }

    public void setSumPrices(Double sumPrices) {
        this.sumPrices = sumPrices;
    }

    public Integer getCountBusincesss() {
        return countBusincesss;
    }

    public void setCountBusincesss(Integer countBusincesss) {
        this.countBusincesss = countBusincesss;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(Long hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public Long getTypes() {
        return types;
    }

    public void setTypes(Long types) {
        this.types = types;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
