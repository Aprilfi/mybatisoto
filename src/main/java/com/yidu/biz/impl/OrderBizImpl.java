package com.yidu.biz.impl;

import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import com.yidu.biz.OrderBiz;
import com.yidu.dao.OrderDao;
import com.yidu.domain.Order;
import com.yidu.domain.paramMap;
import com.yidu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class OrderBizImpl implements OrderBiz {

    private SqlSession sqlSession = MyBatisUtil.getSqlSession();

    private OrderDao orderDao = sqlSession.getMapper(OrderDao.class);

    @Override
    public List<Order> queryOrderByPage() {
        List<Order> orderList = orderDao.findOrderByPage();
        return orderList;
    }

    @Override
    public int queryOrderCount() {
        return orderDao.getOrderCount();
    }

    @Override
    public List<Order> queryPriceByPage(paramMap map) {
        return orderDao.findPriceByPage(map);
    }

    @Override
    public List<Order> QueryConditionalCombination(Map<String, Object> map) {
        return orderDao.ConditionalCombinationQuery(map);
    }

    @Override
    public List<Order> queryTimeByPage(paramMap map) {
        return orderDao.findTimeByPage(map);
    }
}
