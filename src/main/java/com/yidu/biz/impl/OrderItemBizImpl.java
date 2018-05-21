package com.yidu.biz.impl;

import com.yidu.biz.OrderItemBiz;
import com.yidu.dao.OrderItemDao;
import com.yidu.domain.OrderItem;
import com.yidu.util.MyBatisUtil;

public class OrderItemBizImpl implements OrderItemBiz {

    private OrderItemDao orderItemDao = MyBatisUtil.getSqlSession().getMapper(OrderItemDao.class);

    @Override
    public OrderItem queryOrdersItemByOrderId(String orderid) {
        return orderItemDao.findByOrderItemId(orderid);
    }
}
