package top.cflwork.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ContractHouseListVo implements Serializable {

    private Integer houseCount;
    private Integer sumArea;
    private List<HouseVo> houseVoList;
    private List<RentPayVo> rentPayVoList;
}
