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
                                                <p style="float:left;height:31px;line-height:31px;width:100%; margin: 5px 0px 0px 0px"><span style="font-size: small;"><img src="/userfiles/image/feature-hot.png" alt="" style="float:left;" original="/userfiles/image/feature-hot.png"><strong><font color="#ff0066">Hàng Nhập Chính Hãng Hàn Quốc</font></strong></span></p>
                                                <p style="float:left;height:31px;line-height:31px;width:100%; margin: 5px 0px 0px 0px"><strong><span style="font-size: small;"><img src="/userfiles/image/feature-ghfree.png" alt="" style="float:left;" original="/userfiles/image/feature-ghfree.png"></span><span style="color: rgb(255, 0, 102);"><span style="font-size: small;">Giao Hàng Tận Nơi 14 Ngày Làm Việc</span></span></strong></p>
                                                <p style="float:left;height:31px;line-height:31px;width:100%; margin: 5px 0px 0px 0px"><strong><span style="color: rgb(255, 0, 102);"><span style="font-size: small;"><img src="/userfiles/image/feature-trahang.png" alt="" style="float:left;" original="/userfiles/image/feature-trahang.png">Đổi Hàng Trong Vòng 01 Tuần.</span></span></strong></p>
                                                <p><span style="font-size: small;"><font color="#ff0066"> </font></span></p>
                                            </div>

                                            <div class="info_content_share">

                                            </div>
                                            <div class="item_detail_info">
							
							<script type="text/javascript">
							    $(document).ready(function () {
							        $('div.detail_info_content&gt; div').hide();
							        $('div.detail_info_content&gt; b').next('div').show();
							        $('div.detail_info_content&gt; strong').click(function () {
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
									<p><strong style="font-size: 12px;"><a onclick="window.open(this.href,'','resizable=no,location=no,menubar=no,scrollbars=no,status=no,toolbar=no,fullscreen=no,dependent=no,status'); return false" href="/san-pham/order]-ao-so-mi-co-vien-hoa-01343_1133.html">Áo Sơ Mi</a>&nbsp;Cổ Viền Hoa.</strong></p>
<ul class="style_list_checked_simple">
    <li>Áo sơ mi voan là mẫu trang phục lí tưởng cho những cô nàng công sở yêu thích phong cách thanh lịch, nữ tính.</li>
    <li>Thiết kế áo suông với phần cổ áo phối hoa lạ mắt làm điểm nhấn cho trang phục thêm nổi bật.</li>
    <li>Chất liệu voan mịn màng, thoáng mát.</li>
    <li>Kết hợp ăn ý với nhiều loại trang phục khác nhau như chân váy ôm, quần âu hay quần short ...đều đẹp.</li>
    <li>Màu sắc: trắng, đen.</li>
    <li>Trọng lượng: 400g.&nbsp;</li>
    <li>Kích cỡ:&nbsp;</li>
    <table width="300" cellspacing="1" cellpadding="1" border="1">
        <tbody>
            <tr>
                <td>Size</td>
                <td style="text-align: center;">F</td>
                <td style="text-align: center;">L</td>
            </tr>
            <tr>
                <td>Vòng vai ( cm)</td>
                <td style="text-align: center;">33</td>
                <td style="text-align: center;">&nbsp;34.5</td>
            </tr>
            <tr>
                <td>Vòng ngực( cm)</td>
                <td style="text-align: center;">110</td>
                <td style="text-align: center;">118</td>
            </tr>
            <tr>
                <td>Dài tay (cm)</td>
                <td style="text-align: center;">48</td>
                <td style="text-align: center;">49</td>
            </tr>
            <tr>
                <td>Lai áo( cm)</td>
                <td style="text-align: center;">112</td>
                <td style="text-align: center;">118</td>
            </tr>
            <tr>
                <td>Chiều dài</td>
                <td style="text-align: center;">70</td>
                <td style="text-align: center;">71</td>
            </tr>
        </tbody>
    </table>
</ul>
<p>&nbsp;</p>
<p><strong style="color: rgb(255, 0, 102);">*&nbsp;Cách thức mua hàng:</strong>&nbsp;</p>
<p>Đối với hàng Order trực tiếp từ Hàn Quốc, DShop không hỗ trợ 02 hình thức thanh toán:&nbsp;</p>
<p>+ Mua trực tiếp tại cửa hàng.<o:p></o:p></p>
<p>+ Giao hàng thu tiền tận nơi.<o:p></o:p></p>
<p>Quý khách có nhu cầu mua hàng Order, vui lòng làm theo các bước sau:<o:p></o:p></p>
<p>+ Bước 1: Chọn sản phẩm muốn mua.<o:p></o:p></p>
<p>+ Bước 2: Thanh toán trước đơn hàng qua ATM/Internet Banking hoặc chuyển khoản.<o:p></o:p></p>
<p>+ Bước 3: DShop sẽ gọi điện thoại xác nhận khoản thanh toán trong vòng 01 ngày làm việc sau khi nhận được khoản thanh toán của khách hàng.&nbsp;<o:p></o:p></p>
<p>+ Bước 4: DShop sẽ tiến hành giao hàng cho khách hàng trong vòng 14 ngày làm việc sau khi xác nhận thanh toán.&nbsp;<o:p></o:p></p>
<p>&nbsp;</p>
								</div>
                                
                                <p class="clear_line"></p>

                                <script type="text/javascript">
                                    $(document).ready(function () {
                                                                                $('a[name="popup_buy_center"]:first').qtip(
							                                                       {
							                                                           content: {
							                                                               title: {
							                                                                   text: 'BẠN HÃY CHỌN MẪU SẢN PHẨM BÊN DƯỚI',
							                                                                   button: 'X'
							                                                               },
							                                                               url: 'http://thoitrangdshop.vn/detail_bottom_ajax.aspx',
                                                                                           data: { dealid:1133 },
                                                                                           method: 'post'
							                                                           },
							                                                           position: {
							                                                               target: $(document.body), // Position it via the document body...
							                                                               corner: 'center' // ...at the center of the viewport
							                                                           },
							                                                           show: {
							                                                               when: 'click', // Show it on click
							                                                               solo: true // And hide all other tooltips
							                                                               //modal: true
							                                                           },
							                                                           hide: 'unfocus', //hide: false,
							                                                           style: {
							                                                               width: 410,
							                                                               height: { max: 500 },
							                                                               padding: '14px',
							                                                               border: {
							                                                                   width: 9,
							                                                                   radius: 9,
							                                                                   color: '#666666'
							                                                               },
							                                                               name: 'light'
							                                                           },
							                                                           api: {
							                                                               beforeShow: function () {
							                                                                   // Fade in the modal "blanket" using the defined show speed
							                                                                   $('#qtip-blanket').fadeIn(this.options.show.effect.length);
							                                                               },
							                                                               beforeHide: function () {
							                                                                   // Fade out the modal "blanket" using the defined hide speed
							                                                                   $('#qtip-blanket').fadeOut(this.options.hide.effect.length);
							                                                               },
							                                                               onHide: function () {
							                                                                   //$('.content_all_title').html("abc");
							                                                                   //location.reload();
							                                                               }
							                                                           }
							                                                       });    
                                                                                   
                                                                                   
                                                                                   $('a[name="popup_rebuy_center"]:first').qtip(
							                                                       {
							                                                           content: {
							                                                               title: {
							                                                                   text: 'THÔNG BÁO',
							                                                                   button: 'X'
							                                                               },
							                                                               url: 'http://thoitrangdshop.vn/click_ajax.aspx',
                                                                                           data: { dealid:1133 },
                                                                                           method: 'post'
							                                                           },
							                                                           position: {
							                                                               target: $(document.body), // Position it via the document body...
							                                                               corner: 'center' // ...at the center of the viewport
							                                                           },
							                                                           show: {
							                                                               when: 'click', // Show it on click
							                                                               solo: true // And hide all other tooltips
							                                                               //modal: true
							                                                           },
							                                                           hide: 'unfocus', //hide: false,
							                                                           style: {
							                                                               width: 620,
							                                                               height: { max: 500 },
							                                                               padding: '0px',
							                                                               border: {
							                                                                   width: 9,
							                                                                   radius: 9,
							                                                                   color: '#666666'
							                                                               },
							                                                               name: 'light'
							                                                           },
							                                                           api: {
							                                                               beforeShow: function () {
							                                                                   // Fade in the modal "blanket" using the defined show speed
							                                                                   $('#qtip-blanket').fadeIn(this.options.show.effect.length);
							                                                               },
							                                                               beforeHide: function () {
							                                                                   // Fade out the modal "blanket" using the defined hide speed
							                                                                   $('#qtip-blanket').fadeOut(this.options.hide.effect.length);
							                                                               },
							                                                               onHide: function () {
							                                                                   //$('.content_all_title').html("abc");
							                                                                   //location.reload();
							                                                               }
							                                                           }
							                                                       });                   
                                    });
	                            </script>

                                <p class="buy_center_button_box">
					                <a name="popup_buy_center" class="buy_center_button" title="" href="javascript:void(0);"></a>
				                </p>

                                <p class="clear_line"></p>
                                
                                <b class="term_header"><a title="" href="javascript:void(0);">ĐỊA CHỈ SHOP</a></b>
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
