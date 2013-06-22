<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%    
    request.setCharacterEncoding("UTF-8");
    String tuKhoa = request.getParameter("txtTuKhoa");
    if(tuKhoa == null || tuKhoa.equals("Nhập từ khóa...")){
        tuKhoa = "";
    }
    
    String strGiaTu = request.getParameter("txtGiaTu");

    String strGiaDen = request.getParameter("txtGiaDen");

    float giaTu = -1;
    float giaDen = -1;
    if(strGiaTu !=null && !strGiaTu.isEmpty() && !strGiaTu.equals("Giá từ")){
        giaTu = Float.valueOf(strGiaTu);
    }
    if(strGiaDen !=null && !strGiaDen.isEmpty() && !strGiaDen.equals("Giá đến")){
        giaDen = Float.valueOf(strGiaDen);
    }
    request.setAttribute("tuKhoa", tuKhoa);
    request.setAttribute("giaTu", strGiaTu);
    request.setAttribute("giaDen", strGiaDen);
    
    int trang = 1;
    int soLuongTrenTrang = 10;
    String strTrang = request.getParameter("trang");
    if (strTrang != null) {
        trang = Integer.parseInt(strTrang);
    }

    int soTrang = SPDao.tinhSoTrangTimKiemNangCao(tuKhoa, giaTu, giaDen, -1, soLuongTrenTrang);
    request.setAttribute("trang", trang);
    request.setAttribute("soTrang", soTrang);
    
    ArrayList<SPPojo> dsSP = SPDao.timKiemNangCao(tuKhoa, -1, giaTu, giaDen, trang, soLuongTrenTrang);
    request.setAttribute("dsSP", dsSP);
    
    request.setAttribute("trangHienTai","timkiem.jsp?txtTuKhoa=" + tuKhoa + "&txtGiaTu=" + giaTu + "&txtGiaDen=" + giaDen + "&");
%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Shop Quần Áo</title>
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <script type="text/javascript" src="js/jquery-1.4.4.js"></script>
        <script type="text/javascript" src="js/ddaccordion.js"></script>
        <script type="text/javascript" src="js/jquery.bxSlider.js"></script>
        

        <!--[if IE 6]>
        <script src="scripts/DD_belatedPNG_0.0.8a.js"></script>
        <script>
          DD_belatedPNG.fix('img, div, span, a, h1, h2, h3, h4, h5, h6, p, table');
        </script>
        <![endif]-->

        <!--[if lt IE 9]>
                <link rel="stylesheet" type="text/css" href="templates/FIX_IE.css" />
        <![endif]-->
    </head>
    <body style="background:#000 url(imgs/layout10/body_bg.jpg) no-repeat fixed top center;">
        <div id="wrapper_mau_gh"> 

            <!-- begin header -->
            <jsp:include page="subs/header.jsp"/>
            <!-- End header -->

            <div id="content_mau_gh">

                <!-- beginleft -->
                <jsp:include page="subs/left.jsp"/>
                <!-- endleft -->


                <div class="center_c_mau_gh">

                    <%
                         request.setAttribute("title", "Kết quả tìm kiếm cho " + tuKhoa);
                    %>
                    <!-- begin main contents -->
                    <jsp:include page="subs/danhsachsanpham.jsp"/>
                    <!-- end main contents -->
                </div><!-- End .center_c_mau_gh -->

                <!-- begin right-->
                <jsp:include page="subs/right.jsp"/>
                <!-- end right -->

                <div class="clear"></div>

            </div><!-- End #content_mau_gh -->

            <!-- begin footer -->
            <jsp:include page="subs/footer.jsp"/>
            <!-- End footer -->

        </div><!-- End #wrapper_mau_gh -->


    </body>
</html>
