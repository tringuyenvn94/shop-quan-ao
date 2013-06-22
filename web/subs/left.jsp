<%@page import="controller.SessionCounter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%
    int dmID = 0;
    String strDM = request.getParameter("id");
    if (strDM != null) {
        dmID = Integer.parseInt(strDM);
    }
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
                <%for(DanhMucPojo dm : dsDM){
                    if(dm.getMaDanhMuc() != dmID){%>
                <div class="silverheader">
                    <a href="danhmuc.jsp?id=<%=dm.getMaDanhMuc()%>" title="" onclick="changeDM(<%=dm.getMaDanhMuc()%>);"><%=dm.getTenDanhMuc()%></a>
                </div>
                    <%}else{%>
                    <div class="silverheaderCurrent">
                    <a href="danhmuc.jsp?id=<%=dm.getMaDanhMuc()%>" title="" onclick="changeDM(<%=dm.getMaDanhMuc()%>);"><%=dm.getTenDanhMuc()%></a>
                </div>
                <%  }
                }%>
                
                <!-- end menu items -->
                
            </div><!-- End .dmsp_mau_gh -->

        </div><!-- End .main_f_m_gh -->
    </div><!-- End .frame_mau_gh --><!-- End .frame_mau_gh -->

    <div class="frame_mau_gh">
        <h2 class="title_f_m_gh">
            Thống kê truy cập
        </h2>
        <div class="main_f_m_gh">

            <div class="tktc_mau_gh">
                <ul>

                    <li>-:- Đang online : 1000</li>
                    <li>-:- Truy cập trong ngày : 1000</li>
                    <li>-:- Lượt truy cập : 1000</li>
                </ul>
            </div>

        </div>
    </div>
                    <!-- End .frame_mau_gh --><!-- End .frame_mau_gh -->

</div>
                <script type="text/javascript">
                    function changeDM(dmID){

                    }
                </script>