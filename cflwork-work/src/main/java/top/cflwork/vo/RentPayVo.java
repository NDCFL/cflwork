package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 分成房租管理Vo
 */
@Data
public class RentPayVo implements Serializable {

    private Long id;//编号

    private Long hotelId;//酒店编号

    private Long masterId;//业主编号

    private Long companyId; //公司编号

    private BigDecimal baodiPay;//保底金额

    private Integer payTime;//签约年限

    private Integer payType;//支付类别

    private Date payPeriodStart;//总支付开始时间

    private Date payPeriodEnd;//总支付结束时间

    private Date factPayTimeStart;//合同开始时间

    private Date factPayTimeEnd;//合同结束时间

    private String description;//说明

    private Integer isCash;//是否支付

    private Date createTime;//创建时间

    private Byte isActive;//是否激活

    private Double firstPay;//每期支付金额

    private Date firstPayTime;//首次支付时间

    private double sumPay;//已经支付金额

    private Long houseId;//房间名称

    private HotelVo hotelVo;//酒店组件

    private Integer area;//房间面积

    private HouseVo houseVo;//房间组件

    private Integer payMoneyType;//支付类型，有成本，无所本

    private Float payProportion;//支付比例

    private ContractMasterVo contractMasterVo;

    private String name;

    private Date endTime;

    private String houseName;

    private String phone;

    private Integer payDay;

    private Byte orderStatus;

}
