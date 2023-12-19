package com.hkq.servlet;

import com.hkq.services.AdminServices;
import com.hkq.services.AdminServicesImpi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Random;

/**
 * 项目启动前和项目结束后执行的一些初始化、收尾工作
 *
 * @author hkq
 */
public class InitServlet extends HttpServlet {

    /**
     * 定义初始化操作
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(60 * 1000);
                    AdminServices services = new AdminServicesImpi();

                    int count = new Random().nextInt(8);

                    for (int i = 0; i < count; i++) {
                        services.updateToilet(String.valueOf(i + 1), "男");
                    }
                    for (int i = count; i < 8; i++) {
                        services.updateToilet(String.valueOf(i + 1), "女");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
        // do nothing
    }

    /**
     * 定义收尾操作
     */
    @Override
    public void destroy() {
        super.destroy();
        // do nothing
    }
}
