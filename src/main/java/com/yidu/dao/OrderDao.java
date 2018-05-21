package com.yidu.dao;

import com.yidu.domain.Order;
import com.yidu.domain.paramMap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public List<Order> findOrderByPage();

    //@Select("SELECT COUNT(*) AS orderscount FROM orders")
    public int getOrderCount();

    public List<Order> findPriceByPage( paramMap map );

    public List<Order> ConditionalCombinationQuery(Map<String, Object> map);

    public List<Order> findTimeByPage( paramMap map );

    public int getOrderCountWithCriteria( paramMap map);




}
