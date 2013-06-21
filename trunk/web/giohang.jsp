<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %>
<%@page import="pojo.*" %>
<%
    GioHangPojo gioHang = new GioHangPojo();
    if (session.getAttribute("GioHang") != null) {
        gioHang = (GioHangPojo) session.getAttribute("GioHang");
    }
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

                <!-- begin don dat hang -->
                <div id="dondathang">
                    <div class="center_c_mau_gh">
                        <h2 class="title_f_m_gh_main">Thông tin người nhận hàng</h2>
                        <form method="post" action="xulygiohang.jsp?act=dathang">
                            <table width="568" style="background-color:#EEE;border:1px #7f7f7f;padding-left: 5px;">
                                <tr style="height:30px;">
                                    <td width="105">Tên</td>
                                    <td width="447"><label for="txtTen"></label>
                                        <input type="text" name="txtTen" id="txtTen"></td>
                                </tr>
                                <tr style="height:30px;">
                                    <td>Số điện thoại</td>
                                    <td><label for="txtSoDT"></label>
                                        <input type="text" name="txtDienThoai" id="txtSoDT"></td>
                                </tr>
                                <tr style="height:30px;">
                                    <td>Địa Chỉ</td>
                                    <td><textarea name="txtDiaChi" id="txtDiaChi" cols="55" rows="5"></textarea></td>
                                </tr>
                                <tr style="height:30px;">
                                    <td>&nbsp;</td>
                                    <td>
                                            <input type="submit" name="btnChapNhan" id="btnChapNhan" value="Chấp Nhận" class="button" />
                                            <input type="button" name="btnClose" id="btnClose" value="Đóng Lại" onclick="closeDDH();" class="button"/>
                                        </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                    <!-- end don dat hang -->

                    <!-- be gin gio hang -->
                    <div class="center_c_mau_gh">


                        <h2 class="title_f_m_gh_main">Giỏ Hàng</h2>

                        <div class="container-page col1-layout">    


                            <div class="cart">



                                <div class="shop_name">

                                    <div class="rate_item"></div>
                                    <div class="online"></div>
                                </div>

                                <fieldset>
                                    <form name="form" method="POST" action="xulygiohang.jsp?act=capnhat">
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
                                                    <th width="300" rowspan="1"><span class="nobr">Sản phẩm</span></th>
                                                    <th width="70" class="a-center" rowspan="1">Số lượng                        
                                                    </th>

                                                    <th width="150" colspan="1" class="a-center"><span class="nobr">Giá</span></th>
                                                    <th width="150" colspan="1" class="a-center"> Thành tiền</th>
                                                    <th class="a-center" rowspan="1">&nbsp;</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr class="first last">
                                                    <td align="right" class="a-right last" colspan="50">
                                                        <a href="index.jsp" id="buttonTiepTuc" name="btnTiepTuc" value="Tiếp Tục Mua Hàng" class="button">Tiếp Tục Mua Hàng</a>
                                                        <a href="xulygiohang.jsp?act=capnhat"><input id="buttonCapNhat" type="Submit" name="btnCapNhat" value="Cập Nhật" class="button"/></a>
                                                    </td>
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <!-- begin sp -->
                                                <%

                                                    for (int i = 0; i < gioHang.getDsChiTiet().size(); i++) {
                                                        ChiTietDonDatHangPojo ct = gioHang.getDsChiTiet().get(i);
                                                        SPPojo sp = SPDao.laySP(ct.getMaSP());
                                                %>
                                                <tr class="first last odd">
                                                    <td><a class="product-image" title="<%=sp.getTenSP()%>" href="#"><img width="75" height="75" alt="<%=sp.getTenSP()%>" src="<%=sp.getHinhAnh()%>"></a></td>
                                                    <td>
                                                        <h2 class="product-name">
                                                            <a href="chitietsanpham?id=<%=sp.getMaSP()%>"><%=sp.getTenSP()%></a>
                                                        </h2>
                                                    </td>
                                                    <td class="a-center">
                                                        <input name="txtSoLuong<%=i%>" maxlength="12" class="input-text qty" title="Số lượng" size="4" value="<%=ct.getSoLuong()%>" onkeypress="return checkNumber(this, event)"/>
                                                        <button class="button btn-update" title="Cập nhật số lượng" value="update_qty" name="update_cart_action" type="submit"><span></span></button>
                                                    </td>


                                                    <td class="a-center">
                                                        <span class="cart-price">
                                                            <span class="price"><%=sp.getGiaTien()%></span>                
                                                        </span>


                                                    </td>


                                                    <td class="a-center">
                                                        <span class="cart-price">
                                                            <span class="price"><%=ct.getGiaTien()%></span>                            
                                                        </span>
                                                    </td>
                                                    <td class="a-center last">
                                                        <a title="Xóa sản phẩm" href="xulygiohang.jsp?act=xoaSP&idx=<%=i%>">Xóa</a>
                                                    </td>
                                                </tr>
                                                <%}%>
                                                <!-- end sp-->
                                            </tbody>
                                        </table></form>
                                    <script type="text/javascript">decorateTable('shopping-cart-table')</script>
                                </fieldset>

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
                                                        <span class="price"><%=gioHang.getGiaTien()%></span>    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <ul class="checkout-types">
                                            <li>
                                                <%if(user != null){%>
                                                <input id="buttonThanhToan" type="button" name="btnThanhToan" value="Thanh Toán" class="button" onclick="openDDH(1);"/>
                                                <%} else{%>
                                                <input id="buttonThanhToan" type="button" name="btnThanhToan" value="Thanh Toán" class="button" onclick="openDDH(0);"/>
                                                <%}%>

                                            </li>
                                        </ul>
                                    </div>
                                </div>

                            </div>        <span id="fpcIdentifier"></span>   </div>

                    </div>
                    <!-- end gio hang -->
                    <!-- begin right-->
                    <jsp:include page="subs/right.jsp"/>
                    <!-- end right -->

                    <div class="clear"></div>

                </div><!-- End #content_mau_gh -->

                <!-- begin footer -->
                <jsp:include page="subs/footer.jsp"/>
                <!-- End footer -->

            </div><!-- End #wrapper_mau_gh -->
<script type="text/javascript">
    function closeDDH(){
        var btnScrollUp = $('#dondathang');
	//btnScrollUp.toggle(500);
	btnScrollUp.slideUp(500);
    }
    function openDDH(type){
        if(type == 1){
            var btnScrollUp = $('#dondathang');
            //btnScrollUp.toggle(500);
            btnScrollUp.slideDown(500);
        }else{
            window.alert("Đăng nhập để thực hiện chức năng này");
        }
    }
</script>

    </body>
</html>
