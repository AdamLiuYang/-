package com.hkq.controller.admin;

import com.hkq.model.Schedule;
import com.hkq.services.AdminServices;
import com.hkq.services.AdminServicesImpi;
import com.hkq.util.UserPaging;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 搜索用户Controller
 *
 * @author hkq
 */

public class AdminScheduleController extends HttpServlet {
    private int pageSize;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 获取分页大小
        String pageSizeStr = config.getInitParameter("pageSize");
        pageSize = Integer.parseInt(pageSizeStr);
        if (pageSize < 1) {
            throw new RuntimeException("分页大小pageSize不能小于1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int pageNum = Integer.MAX_VALUE;
        String role = req.getParameter("role");

        AdminServices services = new AdminServicesImpi();
        UserPaging page = services.searchAllUser(pageNum, pageSize);
        List<Schedule> scheduleList = services.searchAllSchedule();
        req.setAttribute("page", page);
        req.setAttribute("scheduleList", scheduleList);
        if (role == null) {
            req.setAttribute("role", "admin");
        } else {
            req.setAttribute("role", "user");
        }
        req.setAttribute("uri", "/admin/ScheduleController?");
        req.getRequestDispatcher("/admin/schedule").forward(req, resp);
        return;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
