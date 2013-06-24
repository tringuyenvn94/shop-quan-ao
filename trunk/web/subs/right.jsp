
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%
    KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
    String tuKhoa = (String)request.getAttribute("tuKhoa");
    if(tuKhoa == null || tuKhoa.isEmpty()){
        tuKhoa = "Nhập từ khóa...";
    }
     String giaTu = (String)request.getAttribute("giaTu");
    if(giaTu == null || giaTu.isEmpty()){
        giaTu = "Giá từ";
    }
     String giaDen = (String)request.getAttribute("giaDen");
    if(giaDen == null || giaDen.isEmpty()){
        giaDen = "Giá đến";
    }
%>
<!DOCTYPE html>
<div class="right_mau_gh">

    <!-- begin login -->

    <jsp:include page="loginRegion.jsp"/>
    <!-- end login -->

    <div class="frame_mau_gh">
        <h2 class="title_f_m_gh">
            Tìm kiếm
        </h2><!-- End .title_f_m_gh -->
        <div class="main_f_m_gh">

            <div class="search_mau_gh">
                <form name="frmTimKiem" method ="POST" action="timkiem.jsp">
                    <input name="txtTuKhoa" class="inputsearch_mau_gh" type="text" value="<%=tuKhoa%>" onBlur="if (this.value == '')
                                this.value = 'Nhập từ khóa...';" onFocus="if (this.value == 'Nhập từ khóa...')
                                this.value = '';"/>
                    <div style="padding-top:10px;">
                        <input name="txtGiaTu" class="inputgiatu_mau_gh" type="text" value="<%=giaTu%>" onBlur="if (this.value == '')
                                this.value = 'Giá từ';" onFocus="if (this.value == 'Giá từ')
                                this.value = '';"/>
                        <input name="txtGiaDen" class="inputgiaden_mau_gh" type="text" value="<%=giaDen%>" onBlur="if (this.value == '')
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