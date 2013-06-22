<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%
    int trang = 1;
    int soLuongTrenTrang = 10;
    String strTrang = request.getParameter("trang");
    if (strTrang != null) {
        trang = Integer.parseInt(strTrang);
    }

    int soTrang = SPDao.tinhSoTrangDSSPBanChay(soLuongTrenTrang);
    request.setAttribute("trang", trang);
    request.setAttribute("soTrang", soTrang);
    
    ArrayList<SPPojo> dsSP = SPDao.layDSSPBanChay(trang, 10);
    request.setAttribute("dsSP", dsSP);
    
    request.setAttribute("trangHienTai", "index.jsp?");
    
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
        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#slider1').bxSlider({
                    auto: true,
                    mode: 'fade',
                    pager: false,
                    controls: false
                });
            });
        </script>
        
        

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

                    <!-- begin slide show -->
                    <div class="slide_mau_g">
                        <ul id="slider1" class="multiple">
                            <%for(SPPojo sp : dsSP){%>
                            <li><img style="margin-left: 90px;" src="<%=sp.getHinhAnh()%>" alt=""/></li>
                            <%}%>
                        </ul>
                    </div>
                    <!-- End slide show -->

                    <%
                         request.setAttribute("title", "Sản phẩm bán chạy");
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
