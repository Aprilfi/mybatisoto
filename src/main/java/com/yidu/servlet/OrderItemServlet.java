package com.yidu.servlet;

import com.yidu.biz.OrderItemBiz;
import com.yidu.biz.impl.OrderItemBizImpl;
import com.yidu.domain.OrderItem;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {

    public OrderItemServlet(){
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println(id);

        OrderItemBiz orderItemBiz = new OrderItemBizImpl();

        OrderItem orderItem = orderItemBiz.queryOrdersItemByOrderId(id);

        String jsonstr = JSONArray.fromObject(orderItem).toString();
        System.out.println(jsonstr);
        PrintWriter out = response.getWriter();

        out.print(jsonstr);

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
