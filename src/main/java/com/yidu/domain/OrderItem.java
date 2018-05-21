package com.yidu.domain;

import java.util.Objects;

public class OrderItem {

    private String ordersitemid;

    private String orderid;

    private String ordername;

    private float orderprice;

    private int orderitemtotal;

    private String orderuser;

    public OrderItem() {
    }

    public OrderItem(String ordersitemid, String orderid, String ordername, float orderprice, int orderitemtotal, String orderuser) {
        this.ordersitemid = ordersitemid;
        this.orderid = orderid;
        this.ordername = ordername;
        this.orderprice = orderprice;
        this.orderitemtotal = orderitemtotal;
        this.orderuser = orderuser;
    }

    public String getOrdersitemid() {
        return ordersitemid;
    }

    public void setOrdersitemid(String ordersitemid) {
        this.ordersitemid = ordersitemid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public float getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(float orderprice) {
        this.orderprice = orderprice;
    }

    public int getOrderitemtotal() {
        return orderitemtotal;
    }

    public void setOrderitemtotal(int orderitemtotal) {
        this.orderitemtotal = orderitemtotal;
    }

    public String getOrderuser() {
        return orderuser;
    }

    public void setOrderuser(String orderuser) {
        this.orderuser = orderuser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Float.compare(orderItem.orderprice, orderprice) == 0 &&
                orderitemtotal == orderItem.orderitemtotal &&
                Objects.equals(ordersitemid, orderItem.ordersitemid) &&
                Objects.equals(orderid, orderItem.orderid) &&
                Objects.equals(ordername, orderItem.ordername) &&
                Objects.equals(orderuser, orderItem.orderuser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ordersitemid, orderid, ordername, orderprice, orderitemtotal, orderuser);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "ordersitemid='" + ordersitemid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", ordername='" + ordername + '\'' +
                ", orderprice=" + orderprice +
                ", orderitemtotal=" + orderitemtotal +
                ", orderuser='" + orderuser + '\'' +
                '}';
    }
}
