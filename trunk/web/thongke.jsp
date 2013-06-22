<%@page import="java.util.Calendar"%>
<%@page import="pojo.SPPojo"%>
<%@page import="dao.util.Utility"%>
<%@page import="java.util.List"%>
<%@page import="dao.danhmucdao"%>
<%@page import="pojo.DanhMucPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String act = request.getParameter("submit");
    ArrayList<DanhMucPojo> dsDM = danhmucdao.layDanhMuc(); 
 %>
<!DOCTYPE html>
<html>
<head>
    <title>Thống Kê</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link  href="style/admin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.4.4.js"></script>
</head>
<body>
    <div id="main">
        <div id="header">
            <a href="themsp.jsp" class="logo">Shop Quần Áo</a>
            <ul id="top-navigation">
                <li><a href="themsp.jsp">Thêm sản phẩm</a></li>
                <li><a href="themdm.jsp">Thêm danh mục</a></li>
                <li><a href="thongke.jsp"  class="active">Thống kê</a></li>
                <li><a href="index.jsp" >Home</a></li>
            </ul>
        </div>
        <div id="middle">
          <div id="center-column">
          <div class="titleTable">Doanh Thu
            <a href="#" id="btn1" class="toggleButton" onClick="toggleDiv('#doanhThuDiv');">Đóng/Mở</a>
            </div>
          <div id="doanhThuDiv">
              <form name="frmDT" method="POST" action="doanhthucontoller">
            <table width="635" border="1px" bordercolor="#CCCCCC"  >              
              <tr>
                <td width="159">Tháng
                  <select name="optsThang" id="slcMaDM">
                  <% 
                        Integer thang = (Integer)request.getAttribute("thang");
                        if(thang == null){
                            thang = 0;
                        }
                        for(int i = 1; i <= 12; i++){
                           if(thang == i){ 
                        %>
                        <option selected="true" class="inputdk" value="<%=i%>"><%=i%></option>
                <%}else{%>
                <option class="inputdk" value="<%=i%>"><%=i%></option>
                <%}}%>
                </select>
                Năm
                <label for="optsNam"></label>
                <select name="optsNam" id="optsNam">
                    <% 
                        Integer nam = (Integer)request.getAttribute("nam");
                        if(nam == null){
                            nam = 0;
                        }
                        int y = Calendar.getInstance().get(Calendar.YEAR);
                        for(int i = 2000; i <= y; i++){
                           if(nam == i){ 
                        %>
                        <option selected="true" class="inputdk" value="<%=i%>"><%=i%></option>
                <%}else{%>
                <option class="inputdk" value="<%=i%>"><%=i%></option>
                <%}}%>
                </select></td>
                <td width="457">&nbsp;</td>
              </tr>
              <%
                        List<DanhMucPojo> lstDM =(List<DanhMucPojo>) request.getAttribute("lstDM");
                        List<Float> lstGiaTri = (List<Float>)request.getAttribute("lstGiaTri");
                        float tong = 0;
                        if(lstGiaTri != null){
                        for(int i = 0; i<lstDM.size();i++){
                            tong += lstGiaTri.get(i);
                    
              %>
              <tr>
                  <td><%=lstDM.get(i).getTenDanhMuc()%></td>
                  <td class="cart-price"><%=Utility.toVND(lstGiaTri.get(i))%></td>
              </tr>
              <%}%>
              <tr>
                <td class="bold">Tổng</td>
                <td class="cart-price"><%=Utility.toVND(tong)%></td>
              </tr>
              <%}%>
              <tr>
                <td><input type="submit" name="btnOk1" id="btnOk1" value="OK"></td>
                <td>&nbsp;</td>
              </tr>
              
            </table>
              </form>
            </div>	
            <div class="titleTable" style="margin-top:30px;">Tồn Kho
                <a href="#" id="btn2" class="toggleButton" onClick="toggleDiv('#tonKhoDiv');">Đóng/Mở</a>
                </div>
             <div id="tonKhoDiv">
                 <form name="frmTK" method="POST" action="tonkhocontroller">
            <table width="635" border="1px" bordercolor="#CCCCCC" class="thongkeTable">             
              <tr>
                <td width="157">Loại
                  <select name="optsLoai" id="optsLoai">
                      <%
                    Integer slc = (Integer)request.getAttribute("selectedDM");
                    if(slc == null){
                        slc = -1;
                    }
                    for(DanhMucPojo dm : dsDM){
                    if(dm.getMaDanhMuc() == slc){
                     %>
                     <option selected="true" class="inputdk" value="<%=dm.getMaDanhMuc()%>"><%=dm.getTenDanhMuc()%></option>
                  <%}else{%>
                  <option class="inputdk" value="<%=dm.getMaDanhMuc()%>"><%=dm.getTenDanhMuc()%></option>
                  <%}}%>
                </select></td>
                <td width="453"><label for="optsLoai"></label></td>
              </tr>
              <%
                        List<SPPojo> lstSP =(List<SPPojo>) request.getAttribute("lstSP");
                        if(lstSP != null){
                        int tongTon = (Integer)request.getAttribute("tongTon");
                        int tongTonTheoLoai = 0;
                        for(int i = 0; i<lstSP.size();i++){
                            tongTonTheoLoai += lstSP.get(i).getSoLuongTon();
              %>
              <tr>
                <td><%=lstSP.get(i).getTenSP()%></td>
                <td><%=lstSP.get(i).getSoLuongTon()%></td>
              </tr>
              <%}%>
              <tr>
                <td class="bold">Tổng tồn theo loại</td>
                <td class="bold"><%=tongTonTheoLoai%></td>
              </tr>
              <tr>
                <td class="bold">Tổng tồn</td>
                <td class="bold"><%=tongTon%></td>
              </tr>
              <%}%>
              <tr>
                <td><input type="submit" name="btnOk2" id="btnOk2" value="OK"></td>
                <td>&nbsp;</td>
              </tr>
              
            </table>
                 </form>
            </div>
            
            <p>&nbsp;</p>
          </div>
            <div id="right-column">
                
            </div>
        </div>
        <div id="footer">&copy 2011 Sinh viên khoa CNTT</div>
    </div>
    <script type="text/javascript">
		function toggleDiv(Div){
			$(Div).toggle(500);
		}
    </script>
</body>
</html>