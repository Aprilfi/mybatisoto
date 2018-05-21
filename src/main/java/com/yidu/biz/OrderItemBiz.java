package com.yidu.biz;

import com.yidu.domain.OrderItem;

public interface OrderItemBiz {

    public OrderItem queryOrdersItemByOrderId( String orderid );

}
