package com.yidu.biz;

import com.yidu.domain.Order;
import com.yidu.domain.paramMap;

import java.util.List;
import java.util.Map;

public interface OrderBiz {

    public List<Order> queryOrderByPage();

    public int queryOrderCount();

    public List<Order> queryPriceByPage( paramMap map );

    public List<Order> QueryConditionalCombination(Map<String,Object> map);

    public List<Order> queryTimeByPage( paramMap map );

}
