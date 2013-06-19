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
    int trang = 1;
    int soLuongTrenTrang = 10;
    String strTrang = request.getParameter("trang");
    if (strTrang != null) {
        trang = Integer.parseInt(strTrang);
    }

    int soTrang = SPDao.tinhSoTrang(-1, soLuongTrenTrang);
    request.setAttribute("trang", trang);
    request.setAttribute("soTrang", soTrang);

    ArrayList<SPPojo> dsSP = SPDao.layDanhSachSP(trang, 10);


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
        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#slider1').bxSlider({
                    auto: true,
                    mode: 'fade',
                    pager: true,
                    controls: false
                });
            });
        </script>

        <script type="text/javascript">
            function tick2() {
                $('#ticker_02 li:first').slideUp(function() {
                    $(this).appendTo($('#ticker_02')).slideDown();
                });
            }
            setInterval(function() {
                tick2()
            }, 3000);
        </script>
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

                    <h2 class="title_f_m_gh_main">Chi Tiết Sản Phẩm</h2>
                    <div class="info_content_title">
                        <h1>[ORDER] ÁO SƠ MI CỔ VIỀN HOA 01343</h1>
                    </div>
                    <div class="item_detail_header">

                        <div class="item_detail_header_content">

                            <div class="header_info">
                                <div class="header_info_left">
                                    <div class="flexslider">



                                        <img width="405" height="506" title="[Order] Áo Sơ Mi Cổ Viền Hoa 01343" alt="[Order] Áo Sơ Mi Cổ Viền Hoa 01343" src="http://thoitrangdshop.vn/uploads/slider_images/order]-ao-so-mi-co-vien-hoa-01343-1133_4.jpg" class="clsImage" original="http://thoitrangdshop.vn/uploads/slider_images/order]-ao-so-mi-co-vien-hoa-01343-1133_1.jpg" style="">



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
                                                                                         <strong><font color="#ff0066">Giá</font> : 200.000 VNĐ</strong>
                                                    </span>
                                                </p>
                                                 <p><span style="font-size: small;"><font color="#ff0066"> </font></span></p>
                                            </div>

                                            <div class="info_content_share">

                                            </div>
                                            <div class="item_detail_info">

                                                <script type="text/javascript">
                                                    $(document).ready(function() {
                                                        $('div.detail_info_content&gt; div').hide();
                                                        $('div.detail_info_content&gt; b').next('div').show();
                                                        $('div.detail_info_content&gt; strong').click(function() {
                                                            $(this).next('div').slideToggle(0);
                                                            //.siblings('div:visible').slideUp(0);

                                                            if ($(this).hasClass('open')) {
                                                                $(this).removeClass('open');
                                                            }
                                                            else {
                                                                //$('div.detail_info_content&gt; h3').removeClass('open');
                                                                $(this).addClass('open');
                                                            }
                                                        });
                                                    });
                                                </script>

                                                <div class="detail_info_content">
                                                    <b class="term_header"><a title="" href="javascript:void(0);">THÔNG TIN THÊM</a></b>
                                                    <div class="detail_content" style="display: block;">
                                                       <!-- nội dung content -->
                                                    </div>

                                                    <p class="clear_line"></p>

                                                    <p class="buy_center_button_box">
                                                        <a name="popup_buy_center" class="buy_center_button" title="" href="javascript:void(0);"></a>
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

                <div class="right_mau_gh">

                    <!-- begin login -->
                    <%if (user == null) {%>
                    <jsp:include page="subs/loginRegion.jsp"/>
                    <%}%>
                    <!-- end login -->

                    <div class="frame_mau_gh">
                        <h2 class="title_f_m_gh">
                            Tìm kiếm
                        </h2><!-- End .title_f_m_gh -->
                        <div class="main_f_m_gh">

                            <div class="search_mau_gh">
                                <form>
                                    <input class="inputsearch_mau_gh" type="text" value="Nhập từ khóa..." onBlur="if (this.value == '')
                                                            this.value = 'Nhập từ khóa...';" onFocus="if (this.value == 'Nhập từ khóa...')
                                                            this.value = '';"/>
                                    <div style="padding-top:10px;">
                                        <input class="inputgiatu_mau_gh" type="text" value="Giá từ" onBlur="if (this.value == '')
                                                            this.value = 'Giá từ';" onFocus="if (this.value == 'Giá từ')
                                                            this.value = '';"/>
                                        <input class="inputgiaden_mau_gh" type="text" value="Giá đến" onBlur="if (this.value == '')
                                                            this.value = 'Giá đến';" onFocus="if (this.value == 'Giá đến')
                                                            this.value = '';"/>
                                        <div class="clear"></div>
                                    </div>
                                    <div style="padding-top:10px;">
                                        <div class="clear"></div>
                                    </div>
                                    <div style="text-align:center; padding-top:10px;">
                                        <input title="Tìm kiếm" class="btn_search" type="submit" value="&nbsp;"/>
                                    </div>
                                </form>
                            </div><!-- End .search_mau_gh -->

                        </div><!-- End .main_f_m_gh -->
                    </div><!-- End .frame_mau_gh -->

                </div><!-- End .right_mau_gh -->

                <div class="clear"></div>

            </div><!-- End #content_mau_gh -->

            <!-- begin footer -->
            <jsp:include page="subs/footer.jsp"/>
            <!-- End footer -->

        </div><!-- End #wrapper_mau_gh -->


    </body>
</html>
