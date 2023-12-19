package com.hkq.controller.user;

import com.hkq.model.User;
import com.hkq.services.UserServices;
import com.hkq.services.UserServicesImpi;
import com.hkq.util.CookieSessionParam;
import com.hkq.util.FormParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改用户信息Controller
 *
 * @author hkq
 */

public class UserSignController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute(CookieSessionParam.Session_self);

        // 获取用户参数，直接从session中获取用户参数
        String userId = user.getId();
//        String userId = req.getParameter("userId");
        UserServices services = new UserServicesImpi();

        if (services.getUserSign(userId)) {
            req.setAttribute("mess", "今日已签到");
            req.getRequestDispatcher("/home").forward(req, resp);
            return;
        }

        services.userSign(user.getId());

        // 更新session中的User对象
        req.setAttribute("mess", "签到成功");
        req.getRequestDispatcher("/home").forward(req, resp);


    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
