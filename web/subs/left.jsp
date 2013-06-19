<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%
    ArrayList<DanhMucPojo> dsDM = danhmucdao.layDanhMuc();         
%>
<!DOCTYPE html>
<div class="left_c_mau_gh">

    <div class="frame_mau_gh">
        <h2 class="title_f_m_gh">
            Danh mục sản phẩm
        </h2><!-- End .title_f_m_gh -->
        <div class="main_f_m_gh">

            <div class="dmsp_mau_gh">
                <!-- begin menu items -->  
                <%for(DanhMucPojo dm : dsDM){%>
                <div class="silverheader">
                    <a href="" title="" onclick="changeDM(<%=dm.getMaDanhMuc()%>);"><%=dm.getTenDanhMuc()%></a>
                </div>
                <%}%>
                
                <!-- end menu items -->
                
            </div><!-- End .dmsp_mau_gh -->

        </div><!-- End .main_f_m_gh -->
    </div><!-- End .frame_mau_gh --><!-- End .frame_mau_gh -->

    <div class="frame_mau_gh">
        <h2 class="title_f_m_gh">
            Thống kê truy cập
        </h2><!-- End .title_f_m_gh -->
        <div class="main_f_m_gh">

            <div class="tktc_mau_gh">
                <ul>
                    <li>-:- Đang online : 1000</li>
                    <li>-:- Truy cập trong ngày : 1000</li>
                    <li>-:- Lượt truy cập : 1000</li>
                </ul>
            </div><!-- End .tktc_mau_gh -->

        </div><!-- End .main_f_m_gh -->
    </div><!-- End .frame_mau_gh --><!-- End .frame_mau_gh -->

</div>