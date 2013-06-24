<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %>
<%@page import="pojo.*" %>
<%
    int currMenu = 0;
    String strMenu = request.getParameter("mnu");
    if(strMenu != null && !strMenu.isEmpty()){
        currMenu = Integer.valueOf(strMenu);
    }
// kiem tra user
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
    String[] menus = {"Trang chủ", "Sản phẩm mới", "Khuyến mãi", "Giỏ hàng", "Liên hệ" };
    String[] urls = {"index.jsp?mnu=0", "sanphammoi.jsp?mnu=1", "spkhuyenmai.jsp?mnu=2", "giohang.jsp?mnu=3", "lienhe.jsp?mnu=4" };

%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    </head>
    <body>
        <div id="header_mau_gh">

            <div class="banner_mau_gh">
                <a href="index.jsp" >
                    <img height="200" src="imgs/layout10/banner_background.jpg" alt=""/>
                </a>
            </div><!-- End .banner_mau_gh -->
            <div class="menu_mau_gh">            	
                <ul class="nav_menu_mau_gh">
                    <%
                      for(int i = 0; i < menus.length; i++){
                        if(i == currMenu){
                    %>
                    <li class="curren"><a href="<%=urls[i]%>" title=""><%=menus[i]%></a></li>
                    <li><span class="line_menu"></span></li>
                    <%  }else{%>
                    <li><a href="<%=urls[i]%>" title=""><%=menus[i]%></a></li>
                    <li><span class="line_menu"></span></li>
                    <%  }
                    }%>
                    <%if(user != null && user.isAdmin()){%>
                    <li><a href="themsp.jsp" title="">Administrator</a></li>
                    <li><span class="line_menu"></span></li>
                    <%}%>
                </ul>
                <div class="clear"></div>
            </div><!-- End .menu_mau_gh -->

        </div>
    </body>
</html>