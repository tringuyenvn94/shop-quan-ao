<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String error =(String) request.getAttribute("error");
%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css" href="style/main.css">
<script type="text/javascript" src="js/dangky.js"></script>
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
    
        <div id="header_mau_gh">
        
        	<div class="banner_mau_gh">
            	<img src="imgs/layout10/banner_bg.jpg" alt=""/>
            </div><!-- End .banner_mau_gh -->
            
            <div id="regBlock">
    <h2 class="title_f_m_gh_main">Đăng Ký Thành Viên</h2>
    <form id="frmDangKy" name="frmDangKy" method="post" action="dangkicontroller.do">
    <table width="548" style="margin-left:33%;margin-top:5%;">
      <tr style="height:30px;">
        <td width="146">Tên đăng nhập</td>
        <td width="386"><label for="txtTenDangNhap"></label>
          <input class="regInput" type="text" name="txtTenDangNhap" id="txtTenDangNhap" /></td>
      </tr>
      <tr style="height:30px;">
        <td>Mật khẩu</td>
        <td><label for="txtMatKhau"></label>
            <input id="txtMatKhau" class="regInput" type="password" name="txtMatKhau"  /></td>
      </tr>
      <tr style="height:30px;">
        <td>Nhập lại mật khẩu</td>
        <td><label for="txtMatKhau2"></label>
          <input id="txtMatKhau2" class="regInput" type="password" name="txtMatKhau2"  /></td>
      </tr>
      <tr style="height:30px;">
        <td>Email</td>
        <td><label for="txtEmail">
          <input class="regInput" type="text" name="txtEmail" id="txtEmail" />
        </label></td>
      </tr>
      <tr style="height:30px;">
        <td>Điện Thoại</td>
        <td><label for="txtDT"></label>
          <input class="regInput" type="text" name="txtDT" id="txtDT"></td>
      </tr>
      <tr style="height:30px;">
        <td>Địa Chỉ</td>
        <td><label for="txtDiaChi"></label>
          <textarea class="regInput" name="txtDiaChi" id="txtDiaChi" cols="45" rows="3" style="width:250px;"></textarea></td>
      </tr>
      <tr style="height:30px;">
        <td></td>
        <td><input class="regInput" type="button" name="btnDangKy" id="btnDangKy" value="Đăng Ký" onClick="dangKyClick();"/></td>
      </tr>
      <tr style="height:30px;">
          <%if(error != null && !error.isEmpty()){%>
          <td class ="errorMessage" colspan="2"><%=error%></td>
          <%}%>
      </tr>
    </table>
    </form>
  </div>
        </div><!-- End #header_mau_gh -->

        <div id="footer_mau_gh">
        	<div class="menu_footer">
            	<span><a href="#" title="">Trang chủ</a></span>
                <span>|</span>
            	<span><a href="#" title="">Giới thiệu</a></span>
                <span>|</span>
            	<span><a href="#" title="">Sản phẩm</a></span>
                <span>|</span>
            	<span><a href="#" title="">Tin tức</a></span>
                <span>|</span>
            	<span><a href="#" title="">Khuyến mãi</a></span>
                <span>|</span>
            	<span><a href="#" title="">Thanh toán</a></span>
                <span>|</span>                
            	<span><a href="#" title="">Liên hệ</a></span>
            </div><!-- End .menu_footer -->
            <div class="info_footer">
                Copyright © 2011 giaydior.com. All rights reserved.<br />
                Địa chỉ : 65A2 Đinh Công Tráng, P. Tân Định, Q. 1, Tp. HCM<br />
                Điện thoại : 0933.010.805<br />
                Email : michealton88@gmail.com
            </div><!-- End .info_footer -->
        </div><!-- End #footer_mau_gh -->
      
    </div><!-- End #wrapper_mau_gh -->
    

</body>
</html>

