package com.yidu.dao;

import com.yidu.domain.OrderItem;

public interface OrderItemDao {

    public OrderItem findByOrderItemId( String orderid );

}
