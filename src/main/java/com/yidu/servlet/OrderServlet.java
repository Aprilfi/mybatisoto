package com.yidu.servlet;

import com.yidu.biz.OrderBiz;
import com.yidu.biz.impl.OrderBizImpl;
import com.yidu.domain.Order;
import com.yidu.domain.paramMap;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
//
//    public OrderServlet(){}
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //根据路径后操作方式调用操作方法
//        String method = request.getParameter("method");
//        //定义方法名字符串
//        String findByPage = "findbypage";
//        String addGoods = "addGoods";
//
//        if(findByPage.equals(method)){
//            int pageSize = Integer.parseInt(request.getParameter("limit"));
//            int pageNumber = Integer.parseInt(request.getParameter("offset"));
//            //limit - 1 * offset
//            findByPage(pageSize,pageNumber,request,response);
//        }else if(addGoods.equals(method)){
//            //addGoods(request,response);
//        }
//    }
//
//    private void findByPage(int pageSize, int pageNumber, HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        OrderBiz orderBiz = new OrderBizImpl();
//
//        PrintWriter out = response.getWriter();
//
//        List<Order> orderList =
//                orderBiz.queryOrderByPage(new paramMap(pageNumber,pageSize));
//
//        int totalRows = orderBiz.queryOrderCount();
//
//        String jsonStr = JSONArray.fromObject(orderList).toString();
//
//        //组合符合datagrid要求格式的数据字符串
//        String json = "{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
//        //输出到页面
//        out.println(json);
//        //关闭输出对象
//        out.close();
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request,response);
//    }
}
