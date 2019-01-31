package top.cflwork.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 酒店的收入表，记录哪个公司旗下的哪个酒店，的收入明细
 *
 * @author chglee
 * @email xljx_888888@163.com
 * @date 2018-09-11 16:00:27
 */
@Data
public class IncomeVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;
    //收入编号
    @NotNull
    private Long id;
    //公司编号
    private Long companyId;
    //酒店编号
    private Long hotelId;
    //收入科目编号
    private Long subjectId;
    //收入名称
    @NotNull
    private String incommeName;
    //收入备注
    private String remark;
    //开始收入时间
    private Date startTime;
    //结束收入时间
    private Date endTime;
    //收入总金额
    @NotNull
    private Double money;
    //日收入金额
    @NotNull
    private Double dayMoney;
    //收入结算状态
    private Byte incomeStatus;
    //状态
    private Byte isActive;
    //创建时间
    private Date createTime;
    //酒店组件
    private HotelVo hotelVo;
    //科目名称
    private CashSubjectVo cashSubjectVo;
    @NotNull
    private String temp;
    private  Byte orderStatus;

}
