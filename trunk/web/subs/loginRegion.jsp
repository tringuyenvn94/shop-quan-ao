<%-- 
    Document   : loginRegion
    Created on : Jun 18, 2013, 12:11:31 AM
    Author     : luctanbinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="frame_mau_gh">
    <h2 class="title_f_m_gh">
        Đăng nhập
    </h2><!-- End .title_f_m_gh -->
    <div class="main_f_m_gh">

        <div class="dnhap_mau_gh">
            <!--<embed width="188" height="150" scale="exactfit" quality="high" wmode="transparent" type="application/x-shockwave-flash" src="http://www.youtube.com/v/IxUsgXCaVtc" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>-->
            <div id="dangnhap">
                <form id="form1" name="form1" method="post" action="dangnhapcontroller.do">
                    <p>
                        <label for="user"><strong>User</strong></label>
                        <input id="txtTenDangNhap" name="txtTenDangNhap" type="text" id="user" size="15" />
                    <p>
                        <label for="pas"><strong>Pass</strong></label>
                        <input id="txtMatKhau" name="txtMatKhau" type="password" id="pass" size="15" maxlength="10" />
                    </p>
                    <p><a href="">
                            <input type="submit" name="OK" id="OK" value="Đăng nhập" />
                        </a></p>
                    <p>Bạn chưa có tài khoản?<a href="dangky.jsp">Đăng kí</a></p>
                </form>
            </div>
        </div><!-- End .dnhap_mau_gh -->

    </div><!-- End .main_f_m_gh -->
</div><!-- End .frame_mau_gh -->
