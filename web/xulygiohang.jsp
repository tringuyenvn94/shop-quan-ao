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
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
    GioHangPojo gh = (GioHangPojo) session.getAttribute("GioHang");
    String act = request.getParameter("act");
    if (act.equals("xoaSP")) {
        String strIndex = request.getParameter("idx");
        int index = Integer.parseInt(strIndex);
        int maCT = gh.getDsChiTiet().get(index).getMaChiTiet();
        gh.getDsChiTiet().remove(index);
        if (user != null) {
            chitietdondathangdao.xoa(maCT);
        }
    } else if (act.equals("capnhat")) {
        if (gh != null) {
            for (int i = 0; i < gh.getDsChiTiet().size(); i++) {
                ChiTietDonDatHangPojo ct = gh.getDsChiTiet().get(i);
                int soLuong = 1;
                String name = "txtSoLuong" + i;
                String strSL = request.getParameter(name);
                if (strSL != null) {
                    soLuong = Integer.parseInt(strSL);
                }
                float gia = SPDao.layDonGia(ct.getMaSP());
                ct.setDonGia(soLuong * gia);
                ct.setSoLuong(soLuong);
                if (user != null) {
                    chitietdondathangdao.capNhat(ct.getMaChiTiet(), soLuong);
                }
            }
        }
    } else if (act.equals("dathang")) {
        String hoTen = request.getParameter("txtTen");
        String dienThoai = request.getParameter("txtDienThoai");
        String diaChi = request.getParameter("txtDiaChi");
        
        giohangdao.thanhToan(gh, user, hoTen, dienThoai, diaChi);
        
        session.setAttribute("GioHang", null);
        response.sendRedirect("index.jsp");
    }
    session.setAttribute("GioHang", gh);
    response.sendRedirect("giohang.jsp");
%>
