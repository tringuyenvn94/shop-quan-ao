<%-- 
    Document   : chitietsanpham
    Created on : Jun 19, 2013, 10:41:40 AM
    Author     : NMS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%
    int id = -1;
    String strId = request.getParameter("id");
    if (strId != null) {
        id = Integer.parseInt(strId);
    }
    SPPojo sp = SPDao.laySP(id);
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Sản Phẩm</title>
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <script type="text/javascript" src="js/jquery-1.4.4.js"></script>
        <script type="text/javascript" src="js/ddaccordion.js"></script>
        <script type="text/javascript" src="js/jquery.bxSlider.js"></script>
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


                    <h2 class="title_f_m_gh_main"><%=sp.getTenSP()%></h2>
                    <div class="item_detail_header">

                        <div class="item_detail_header_content">

                            <div class="header_info">
                                <div class="header_info_left">
                                    <div class="flexslider">
                                        <img width="300" height="370" title="<%=sp.getTenSP()%>" alt="<%=sp.getTenSP()%>" src="<%=sp.getHinhAnh()%>" class="clsImage" original="<%=sp.getHinhAnh()%>" style="">
                                    </div>
                                    <div class="info_left_type_1 dealtype"></div>
                                </div>

                                <div class="header_info_right">

                                    <div class="info_right_info">

                                        <div class="right_info_content">
                                            <div class="info_content_buy">
                                                <a title="" class="buy_button" name="popup_buy" href="javascript:void(0);"></a>
                                            </div>

                                            <div class="info_content_note">
                                                <p style="float:left;height:31px;line-height:31px;width:100%; margin: 5px 0px 0px 0px">
                                                    <span style="font-size: small;"><img src="/userfiles/image/feature-hot.png" alt="" style="float:left;" original="/userfiles/image/feature-hot.png"
                                                                                         <strong><font color="#ff0066">Giá</font> : <%=sp.getGiaTien()%></strong>
                                                    </span>
                                                </p>
                                                 <p><span style="font-size: small;"><font color="#ff0066"> </font></span></p>
                                            </div>

                                            <div class="info_content_share">

                                            </div>
                                            <div class="item_detail_info">

                                                <script type="text/javascript">
                                                    function toggleContent(){
                                                        $('#noiDungSP').toggle(500);
                                                    }
                                                       
                                                </script>

                                                <div class="detail_info_content">
                                                    <b class="term_header"><a title="" href="#" onclick="toggleContent();">THÔNG TIN THÊM</a></b>
                                                    <div id ="noiDungSP" class="detail_content" style="display: block;">
                                                       <!-- nội dung content -->
                                                       <%=sp.getMoTa()%>>
                                                    </div>

                                                    <p class="clear_line"></p>

                                                    <p class="buy_center_button_box">
                                                        <a name="popup_buy_center" class="buy_center_button" title="" href="xulydatmua.jsp?id=<%=sp.getMaSP()%>"></a>
                                                    </p>

                                                    <p class="clear_line"></p>

                                                    <div class="detail_content" style="display: block;">

                                                    </div>								
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>


                    <!-- End .frame_product_mau_gh -->
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
