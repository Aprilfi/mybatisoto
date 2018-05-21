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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    public SearchServlet(){
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据路径后操作方式调用操作方法
        String method = request.getParameter("method");
        //定义方法名字符串
        String priceSearch = "priceSearch";
        String timeSearch = "timeSearch";

        if(priceSearch.equals(method)){
            float priceStart = Float.parseFloat(request.getParameter("pstart"));
            float priceEnd = Float.parseFloat(request.getParameter("pend"));
            priceSearch(priceStart,priceEnd,request,response);
        }else if(timeSearch.equals(method)){
            String timeStart = request.getParameter("tstart");
            String timeEnd = request.getParameter("tend");
            timeSearch(timeStart,timeEnd,request,response);
        }
    }

    private void timeSearch(String timeStart, String timeEnd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OrderBiz orderBiz = new OrderBizImpl();
        System.out.println(timeStart+"  "+timeEnd);
        paramMap map = new paramMap();
        map.setTimeStart(timeStart);
        map.setTimeEnd(timeEnd);

        List<Order> orderList = orderBiz.queryTimeByPage( map );

        String jsonStr = JSONArray.fromObject(orderList).toString();
        System.out.println(jsonStr);

        PrintWriter out = response.getWriter();

        if(orderList.size() == 0){
            out.print("fair");
        }else{
            out.print(jsonStr);
        }
        out.close();
    }

    private void priceSearch(float priceStart, float priceEnd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OrderBiz orderBiz = new OrderBizImpl();

        paramMap map = new paramMap();
        map.setPriceStart(priceStart);
        map.setPriceEnd(priceEnd);

        List<Order> orderList = orderBiz.queryPriceByPage(map);
        String jsonStr = JSONArray.fromObject(orderList).toString();
        System.out.println(jsonStr);

        PrintWriter out = response.getWriter();

        if(orderList.size() == 0){
            out.print("fair");
        }else{
            out.print(jsonStr);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
