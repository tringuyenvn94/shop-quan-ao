<%-- 
    Document   : xulygiohang
    Created on : Jun 20, 2013, 1:21:59 AM
    Author     : luctanbinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("User");
    String act = request.getParameter("act");
    if (act.equals("xoaSP")) {
        String strIndex = request.getParameter("idx");
        int index = Integer.parseInt(strIndex);
        GioHangPojo gh = (GioHangPojo) session.getAttribute("GioHang");
        int maCT = gh.getDsChiTiet().get(index).getMaChiTiet();
        gh.getDsChiTiet().remove(index);
        if (user != null) {
            chitietdondathangdao.xoa(maCT);
        }
        session.setAttribute("GioHang", gh);

    }
    response.sendRedirect("giohang.jsp");
%>
