<%@page import="ManagerDAO.ManagerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException" %>
 <%
    String novelNumStr = request.getParameter("novelNum");
    if (novelNumStr == null) {
    } else {
        int novelNum = 0;
        try {
            novelNum = Integer.parseInt(novelNumStr);
            ManagerDAO mDAO = new ManagerDAO();
            mDAO.publicNovel(novelNum);
            out.println("<script>alert('해당 소설이 공개로 전환되었습니다.'); window.close();</script>");
        } catch (NumberFormatException e) {
            // 올바른 숫자 형식이 아닌 경우 처리
        } catch (SQLException e) {
            // SQL 예외 처리
        }
    }
%>
 