package com.hkq.controller.admin;

import com.hkq.services.AdminServices;
import com.hkq.services.AdminServicesImpi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 管理员更新用户Controller
 * <p>
 * type = delete|freeze|recover|resetcode
 * <p>
 * 已经禁用删除用户功能
 *
 * @author hkq
 */
public class AdminUpdateScheduleController extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> userIds = Arrays.asList(req.getParameterValues("userIds"));
        List<String> dates = Arrays.asList(req.getParameterValues("dates"));
        ;
//        if ("".equals(userId)) {
//            req.setAttribute("mess", "请选择用户名");
//            req.getRequestDispatcher("/admin/home").forward(req, resp);
//            return;
//        }

        AdminServices services = new AdminServicesImpi();
        for (int i = 0; i < userIds.size(); i++) {
            services.updateSchedule(userIds.get(i), dates.get(i));
        }
        String result = null;

        req.setAttribute("mess", "操作成功");

        req.getRequestDispatcher("/admin/home").forward(req, resp);
        return;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
