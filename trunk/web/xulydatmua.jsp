
<%@page import="pojo.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
            SPPojo sp = new SPPojo();
            String ma = request.getParameter("id");
            int maSP = 0;
            if (ma != null) {
                maSP = Integer.parseInt(ma);
                sp = SPDao.laySP(maSP);
            }

            GioHangPojo gioHang = new GioHangPojo();
            if (session.getAttribute("GioHang") != null) {
                gioHang = (GioHangPojo) session.getAttribute("GioHang");
            }
            gioHang = giohangdao.ThemSP(sp, 1, gioHang, user);
            session.setAttribute("GioHang", gioHang);
           response.sendRedirect("giohang.jsp");
%>

