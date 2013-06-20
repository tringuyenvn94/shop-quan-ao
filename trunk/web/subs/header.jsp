<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %>
<%@page import="pojo.*" %>
<%
// kiem tra user
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    </head>
    <body>
        <div id="header_mau_gh">

            <div class="banner_mau_gh">
                <img src="imgs/layout10/banner_bg.jpg" alt=""/>
            </div><!-- End .banner_mau_gh -->
            <div class="menu_mau_gh">            	
                <ul class="nav_menu_mau_gh">
                    <li class="curren"><a href="index.jsp" title="">Trang chủ</a></li>
                    <li><span class="line_menu"></span></li>
                    <li><a href="" title="">Sản phẩm bán chạy</a></li>
                    <li><span class="line_menu"></span></li>
                    <li><a href="" title="">Khuyến mãi</a></li>
                    <li><span class="line_menu"></span></li>
                    <li><a href="giohang.jsp" title="">Giỏ hàng</a></li>
                    <li><span class="line_menu"></span></li>
                    <li><a href="" title="">Liên hệ</a></li>
                    <li><span class="line_menu"></span></li>
                </ul>
                <!-- welcome user -->
                <%if (user != null) {%>
                <div id="welcomeUser">Xin chào <%=user.getTenDangNhap()%>, <a href="thoat.jsp" title="" style="color:#FF0;">Thoát</a></div>
                <%}%>
                <!-- end welcome user -->
                <div class="clear"></div>
            </div><!-- End .menu_mau_gh -->

        </div>
    </body>
</html>