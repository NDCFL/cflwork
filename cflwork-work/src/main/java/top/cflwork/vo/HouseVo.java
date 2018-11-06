package top.cflwork.vo;

import lombok.Data;

import java.util.Date;

@Data
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

    private Integer houseType;

    private Date leaveTime;

    private Long companyId;

    private Integer houseTypes;



}