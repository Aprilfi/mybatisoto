package com.yidu.domain;

import com.github.pagehelper.PageHelper;
import com.yidu.biz.OrderBiz;
import com.yidu.biz.impl.OrderBizImpl;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderQueryTest {

    @Test
    public void QueryTest(){
        BasicConfigurator.configure();
        OrderBiz orderBiz = new OrderBizImpl();

        Map<String, Object> map = new HashMap<>();

        // map.put("ordertime","2016-08-17 23:43:12");
        // map.put("orderprice",3000);
        // map.put("orderdescribe","梁巩买了");

        List<String> nameList = new ArrayList<>();

        nameList.add("222000");
        nameList.add("777000");
        nameList.add("111222");
        nameList.add("111333");

        map.put("orderidList",nameList);

        List<Order> orderList = orderBiz.QueryConditionalCombination(map);

        for(Order order : orderList) {
            System.out.println(order.toString());
        }


    }

    @Test
    public void QueryPageTest() {
        BasicConfigurator.configure();
        OrderBiz orderBiz = new OrderBizImpl();

        // 获得表的总行数
        int rows = orderBiz.queryOrderCount();
        System.out.println("rows:"+rows);

        //分页查询
        PageHelper.offsetPage(0,5);

        List<Order> orderList1 = orderBiz.queryOrderByPage();
        System.out.println("使用了分页插件");
        for(Order order : orderList1) {
            System.out.println(order.toString());
        }
    }

}
