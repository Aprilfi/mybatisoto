package com.yidu.servlet;

import com.yidu.biz.UserDataBiz;
import com.yidu.biz.impl.UserDataBizImpl;
import com.yidu.domain.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: WuHongLin
 * @Description: 对业主前端界面进行请求转发
 * @Date: 19:56 2018/3/8 0008
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据路径后操作方式调用操作方法
        String method=request.getParameter("method");

        /*定义方法名字符串*/
        String login = "login";
        String register = "register";

        //判断操作方式
        if (login.equals(method)) {
            login(request,response);
        } else if (register.equals(method)) {
            register(request,response);
        }

    }

    /**
     * 注册添加用户资料
     * @param request
     * @param response
     */
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取提交表单内的参数
        String name = request.getParameter("usernameArray");
        String password = request.getParameter("userpasswArray");
        String sex = request.getParameter("usersexArray");
        String year = request.getParameter("useryearArray");
        String month = request.getParameter("usermonthArray");
        String nub = request.getParameter("usernubArray");
        String phone = request.getParameter("userphonenubArray");

        UserData userData = new UserData(name,password,sex,year+"-"+month+"-"+nub,phone);
        UserDataBiz userDataBiz = new UserDataBizImpl();
        PrintWriter out = response.getWriter();

        if(userDataBiz.addUser(userData))
            out.print("success");
        else
            out.print("fair");

        out.close();
    }

    /**
     * 登录验证用户资料
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取提交表单内的参数
        String name = request.getParameter("nameArray");
        String password = request.getParameter("passwordArray");

        UserDataBiz userDataBiz = new UserDataBizImpl();

        List<UserData> userDataList = userDataBiz.queryUserByName(name);

        PrintWriter out = response.getWriter();

        if(userDataList.size() == 0){
            // 将登录状态修改为失败
            out.print("fair");
        }else{
            for(UserData userData : userDataList){
                if(userData.getPassword().equals(password)) {
                    // 将登录状态保存到session对象中
                    HttpSession session = request.getSession();
                    session.setAttribute("username",name);
                    out.print("success");
                }else{
                    // 将登录状态修改为失败
                    out.print("fair");
                }
            }

        }
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
