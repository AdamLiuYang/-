<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%-- 定义Css样式 --%>
<style type="text/css">
    html, body {
        width: 100%;
        height: 100%;
        margin: 0;
        padding: 0;
        font-family: verdana, arial, sans-serif;
        background: url('https://picss.sunbangyan.cn/2023/12/07/af881ff15583da6f373eb439f180d5e6.jpeg') no-repeat center center fixed; /* 设置背景图片 */
        background-size: cover; /* 确保背景图片覆盖整个窗口 */
    }

    #client_body, #admin_body, #admin_login_body {
        width: 100%;
        box-sizing: border-box;
        border: none;
        margin: 0 auto;
        padding: 20px;
        overflow-y: auto;
        display: flex;
        flex-direction: column;
        align-items: center;
        background: rgba(255, 255, 255, 0.8); /* 添加半透明白色背景以增加文字可读性 */
    }


    .web_logo {
        font-size: 60px; /* 将字体大小增大三倍 */
        font-weight: bold;
        padding-bottom: 30px; /* 增大间距 */
    }

    .red_12size_text {
        font-size: 36px; /* 将字体大小增大三倍 */
        color: red;
    }

    .elem {
        margin: 24px 0px; /* 增大间距 */
    }

    .my_github {
        font-size: 39px; /* 将字体大小增大三倍 */
        margin-bottom: 30px; /* 增大间距 */
    }

    hr {
        width: 100%;
        margin: 40px 0; /* 增大间距 */
        border: 1px solid #666666;
    }

    /* 超级简单的表格样式 */
    table {
        width: 100%;
        font-family: verdana, arial, sans-serif;
        font-size: 48px; /* 将字体大小增大三倍 */
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }

    table th {
        border-width: 1px;
        padding: 24px 45px; /* 增大间距 */
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table td {
        border-width: 1px;
        padding: 24px 45px; /* 增大间距 */
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>

