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
                            <li><img src="<%=sp.getHinhAnh()%>" alt=""/></li>
                            <%}%>
                        </ul>
                    </div>
                    <!-- End slide show -->

                    <div class="frame_product_mau_gh">
                        <!-- sp title -->
                        <h2 class="title_f_m_gh_main">Sản phẩm bán chạy</h2>
                        <!-- end sp title -->
                        <div class="main_f_p_m_gh">
                            <div class="prod_mau_gh">
                                <ul>
                                    <!-- begin list sp -->
                                    <%for(SPPojo sp : dsSP){%>
                                    <li>
                                        <a href="chitietsanpham.jsp" title=""><img src="<%=sp.getHinhAnh()%>" alt=""/></a>
                                        <h2 class="title_prod_news">
                                            <a href="#" title=""><%=sp.getTenSP()%></a>
                                        </h2>
                                        <h4 class="price_prod_mau_gh"><%=sp.getGiaTien()%></h4>
                                        <h2 class="title_prod_news">
                                            <a href="#" title="">Cho Vào Giỏ Hàng</a>
                                        </h2>
                                    </li>
                                    <%}%>                                    
                                    <!-- end list sp -->
                                    <div class="clear"></div>
                                </ul>
                            </div><!-- End .prod_mau_gh -->

                        </div><!-- End .main_f_p_m_gh -->
                        
                        <!-- begin phantrang -->
                        <jsp:include page="subs/phantrang.jsp"/>
                        <!-- end phantrang -->
                        
                    </div><!-- End .frame_product_mau_gh -->
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
