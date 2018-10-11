package top.cflwork.service;

import top.cflwork.vo.CustomerOrderOTAVO;

import java.util.List;

public interface CustomerOrderOTAService extends BaseService<CustomerOrderOTAVO> {

    void batchSave(List<Object> orders);

}
