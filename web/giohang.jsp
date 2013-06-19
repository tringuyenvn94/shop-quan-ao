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


                    <h2 class="title_f_m_gh_main">Giỏ Hàng</h2>

                    <div class="container-page col1-layout">    


                        <div class="cart">
   


                            <div class="shop_name">
                     
                                <div class="rate_item"></div>
                                <div class="online"></div>
                            </div>

                            <form method="post" action="http://www.sendo.vn/checkout/cart/updatePost/quoteId/431419/">
                                <fieldset>
                                    <table class="data-table cart-table" id="shopping-cart-table">
                                        <colgroup><col width="1">
                                            <col>
                                            <col width="1">
                                            <col width="1">
                                            <col width="1">
                                            <col width="1">
                                            <col width="1">

                                        </colgroup><thead>
                                            <tr class="first last">
                                                <th rowspan="1">&nbsp;</th>
                                                <th width="350" rowspan="1"><span class="nobr">Sản phẩm</span></th>
                                                <th width="90" class="a-center" rowspan="1">Số lượng                        
                                                </th>

                                                <th width="150" colspan="1" class="a-center"><span class="nobr">Giá</span></th>
                                                <th width="150" colspan="1" class="a-center"> Thành tiền</th>
                                                <th class="a-center" rowspan="1">&nbsp;</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr class="first last">
                                                <td align="right" class="a-right last" colspan="50">
                                                    <button onclick="setLocation('#')" class="button btn-continue" title=" Tiếp tục mua hàng" type="button"><span><span> Tiếp tục mua hàng</span></span></button>

                                                    <button id="empty_cart_button" class="button btn-empty m_l10" title="Xóa hàng trong giỏ" value="empty_cart" name="update_cart_action" type="submit"><span><span>Xóa hàng trong giỏ</span></span></button>
                                                </td>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr class="first last odd">
                                                <td><a class="product-image" title="Giầy Cao Gót" href="#"><img width="75" height="75" alt="Giầy Cao Gót" src="http://media.sendo.vn/catalog/product/cache/1/thumbnail/75x/9df78eab33525d08d6e5fb8d27136e95/c/g/cg_0029_3__1_1.png"></a></td>
                                                <td>
                                                    <h2 class="product-name">
                                                        <a href="#">Giầy Cao Gót</a>
                                                    </h2>
                                                    <dl class="item-options">
                                                        <dt>Kích thước</dt>
                                                        <dd>Size 35                            </dd>
                                                        <dt>Màu sắc</dt>
                                                        <dd>Đen                            </dd>
                                                    </dl>
                                                </td>
                                                <td class="a-center">
                                                    <input maxlength="12" class="input-text qty" title="Số lượng" size="4" value="1" onkeypress="return checkNumber(this, event)" name="cart[538175][qty]">
                                                    <button class="button btn-update" title="Cập nhật số lượng" value="update_qty" name="update_cart_action" type="submit"><span></span></button>
                                                </td>


                                                <td class="a-center">
                                                    <span class="cart-price">
                                                        <span class="price">280,000&nbsp;VNĐ</span>                
                                                    </span>


                                                </td>


                                                <td class="a-center">
                                                    <span class="cart-price">

                                                        <span class="price">280,000&nbsp;VNĐ</span>                            
                                                    </span>
                                                </td>
                                                <td class="a-center last"><a class="btn-remove btn-remove2" title="Xóa sản phẩm" href="http://www.sendo.vn/checkout/cart/delete/id/538175/quoteId/431419/uenc/aHR0cDovL3d3dy5zZW5kby52bi9jaGVja291dC9jYXJ0Lw,,/">Xóa sản phẩm</a></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <script type="text/javascript">decorateTable('shopping-cart-table')</script>
                                </fieldset>
                            </form>
                            <div class="cart-collaterals">
                                <div class="col2-set">
                                    <div class="col-2">

                                    </div>
                                </div>
                                <div style="width: 200px;" class="totals">
                                    <table id="shopping-cart-totals-table">
                                        <colgroup><col>
                                            <col width="1">
                                        </colgroup><tfoot>
                                        </tfoot>
                                        <tbody>
                                            <tr>
                                                <td>
                                                </td>
                                                <td width="40%" colspan="2" class="a-right" style=" ">        
                                                    Tổng cộng 
                                                </td>
                                                <td class="a-right" style="">
                                                    <span class="price">280,000&nbsp;VNĐ</span>    </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <ul class="checkout-types">
                                        <li>    <button onclick="loginPopup('http://www.sendo.vn/customer/account/loginPopup/redirect/http%3A%2F%2Fwww.sendo.vn%2Fcheckout%2Fonepage%2Findex%2Fshop%2F1138%2F/', 'http://media.buyer.dev.sendo.vn/seller/media/')" href="javascript:void(0)" class="button btn-proceed-checkout btn-checkout" title="Thanh toán"><span><span>Thanh toán</span></span></button>

                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </div>        <span id="fpcIdentifier"></span>   </div>

                </div>
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
