package top.cflwork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.cflwork.vo.OrderItemsVo;

import java.util.List;

@Repository
public interface OrderItemsDAO extends  BaseDAO<OrderItemsVo>{
    List<OrderItemsVo> findList(String userCard);
    List<OrderItemsVo> listPage(@Param("startPage") int startPage, @Param("pageSize") int pageSize, @Param("cardId") String cardId);
}
