package top.cflwork.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * 酒店的支出表，记录哪个公司旗下的哪个酒店，的支出明细
 *
 * @author chglee
 * @email xljx_888888@163.com
 * @date 2018-09-11 16:00:27
 */
@Data
public class OutcomeVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //排序字段
    private String sort;
    //排序规则
    private String order;

    //支出编号
    @NotNull
    @Excel(name = "支出编号",orderNum = "0")
    private Long id;
    //公司编号
    @Excel(name = "公司编号", orderNum = "1")
    private Long companyId;
    //酒店编号
    @Excel(name = "酒店编号", orderNum = "2")
    private Long hotelId;
    //支出科目编号
    private Long subjectId;
    //支出名称
    @NotNull
    private String outcommeName;
    //支出备注
    private String remark;
    //开始支出时间
    private Date startTime;
    //结束支出时间
    private Date endTime;
    //支出总金额
    @NotNull
    private Double money;
    //日支出金额
    @NotNull
    private Double dayMoney;
    //支出结算状态
    private Byte outcomeStatus;
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
    private Byte orderStatus;


}
