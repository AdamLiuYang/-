<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.hkq.util.UserPaging" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hkq.model.User" %>
<%@ page import="com.hkq.model.Schedule" %>
<!DOCTYPE html>
<html>
<head>
    <title>清洁员排班界面</title>
    <%@ include file="/WEB-INF/style.jsp" %>
</head>

<%@include file="/WEB-INF/admin/admin_header.jsp" %>

<div>

    <form action="${pageContext.request.contextPath}/admin/UpdateScheduleController" method="POST">
        <%--        ${requestScope.page.data}--%>
        <ul>
            <%--            <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="bb"/>--%>
            <%--            <c:forEach var="row" items="${['1','2','3']}">--%>
            <%--                <li style="text-decoration: none;list-style-type:none;">--%>
            <%--                        ${bb}--%>
            <%--                    <select>--%>
            <%--                        <option value="volvo">PHP中文网</option>--%>
            <%--                        <option value="saab">百度</option>--%>
            <%--                        <option value="opel">腾讯</option>--%>
            <%--                        <option value="audi">新浪</option>--%>
            <%--                    </select>--%>
            <%--                </li>--%>
            <%--            </c:forEach>--%>
            <%

                LocalDate today = LocalDate.now();
                for (int i = 0; i < 7; i++) {
                    LocalDate nextDay = today.plusDays(i);
            %>
            <li style="text-decoration: none;list-style-type:none;">
                <input type="text" name="dates" readonly value="<%= nextDay %>"/>
                <select name="userIds">
                    <c:forEach var="row" items="${requestScope.page.data}">
                        <%
                            List<Schedule> scheduleList = (List<Schedule>) pageContext.getAttribute("scheduleList", PageContext.REQUEST_SCOPE);
                            User row = (User) pageContext.getAttribute("row", PageContext.PAGE_SCOPE);
                            System.out.println(row.getId());
                            boolean flag = false;
                            for (int j = 0; j < scheduleList.size(); j++) {
                                System.out.println(nextDay.toString());
                                System.out.println(nextDay.toString().equals(scheduleList.get(j).getSchedule_date()));
                                if (nextDay.toString().equals(scheduleList.get(j).getSchedule_date())) {
                                    if (row.getId().equals(scheduleList.get(j).getUser_id())) {
                                        flag = true;
                                    }
                                }
                            }
                        %>
                        <option value="${row.id}"
                                <c:choose>
                                    <c:when test="<%= flag %>">selected</c:when>
                                </c:choose>
                        >${row.id}</option>
                    </c:forEach>
                </select>
            </li>
            <% }%>
        </ul>
        <div class="elem">
            <%--            <a href="${pageContext.request.contextPath}/home"> <input type="button" value="返回"/> </a>--%>
            <c:choose>
                <c:when test="${requestScope.role=='admin'}">
                    <input type="submit" value="修改"/>
                </c:when>
            </c:choose>

        </div>
    </form>
</div>

<%@include file="/WEB-INF/admin/admin_footer.jsp" %>
</html>