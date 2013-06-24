
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@page import="dao.*" %> 
<%@page import="pojo.*" %> 
<%@page import="dao.util.Utility"%>
<%
    ArrayList<SPPojo> dsSP = (ArrayList<SPPojo>)request.getAttribute("dsSP");
    String title = (String)request.getAttribute("title");
%>
<!DOCTYPE html>
<div class="frame_product_mau_gh">
    <!-- sp title -->
    <h2 class="title_f_m_gh_main"><%=title%></h2>
    <!-- end sp title -->
    <div class="main_f_p_m_gh">
        <div class="prod_mau_gh">
            <% if(dsSP != null && !dsSP.isEmpty()){%>
            <ul>
                <!-- begin list sp -->
                <%for (SPPojo sp : dsSP) {%>
                <li>
                    <a href="chitietsanpham.jsp?id=<%=sp.getMaSP()%>"><img src="<%=sp.getHinhAnh()%>" title="<%=sp.getShortMoTa()%>"/></a>
                   
                    <h2 class="title_prod_news">
                        <a href="#" title=""><%=sp.getTenSP()%></a>
                    </h2>
                    <h4 class="price_prod_mau_gh"><%=sp.getGiaTien()%></h4>
                    <%if(sp.getMaKhuyenMai() > 0){
                       KhuyenMaiPojo km = KhuyenMaiDao.layKhuyenMai(sp.getMaKhuyenMai());
                   %>
                   <h2 class="title_prod_news">KM: <font style="color: #CC0000"><%=km.getNoiDung()%></font></h2>
                    <%}%>
                    <h2 class="title_prod_news">
                        <form name="frmDatMua" method="POST" action="spcontroller">
                            <input type="hidden" name="id" value="<%=sp.getMaSP()%>"/>
                            <a href="#" onclick="document.forms['frmDatMua'].submit();" title="">Cho Vào Giỏ Hàng</a>
                        </form>
                    </h2>
                </li>
                <%}%>                                    
                <!-- end list sp -->
                <div class="clear"></div>
            </ul>
                <%}else{%>
                Không có sản phẩm nào trong mục này.
                <%}%>
        </div><!-- End .prod_mau_gh -->

    </div><!-- End .main_f_p_m_gh -->

    <!-- begin phantrang -->
    <% if(dsSP != null && !dsSP.isEmpty()){%>
    <jsp:include page="phantrang.jsp"/>
    <%}%>
    <!-- end phantrang -->

</div><!-- End .frame_product_mau_gh -->
