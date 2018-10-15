package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RentVo implements Serializable{
    private int rentHouseCount;//分成房源总数
    private long rentHouseSumArea;//分成房源总面积
    private float money;//单平收益
    private int payMoneyHouse;//待结算的房间
    private float sumMoney;//总金额

}
