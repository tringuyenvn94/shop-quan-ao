<%@page import="dao.danhmucdao"%>
<%@page import="pojo.DanhMucPojo"%>
<%@page import="pojo.DanhMucPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<DanhMucPojo> dsDM = danhmucdao.layDanhMuc(); 
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link  href="style/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="main">
        <div id="header">
            <a href="#" class="logo">Shop Quần Áo</a>
            <ul id="top-navigation">
                <li><a href="themsp.jsp" class="active">Thêm sản phẩm</a></li>
                <li><a href="themdm.jsp">Thêm danh mục</a></li>
                <li><a href="thongke.jsp" >Thống kê</a></li>
                <li><a href="index.jsp" >Home</a></li>
            </ul>
        </div>
        <div id="middle">
          <div id="center-column">
              <form enctype="multipart/form-data" name="frmThemSP" method="POST" action="themspcontroller">
            <table width="628" >
              <tr>
                <td width="128">Tên sản phẩm</td>
                <td width="488"><label for="txtTen"></label>
                <input type="text" name="txtTen" id="txtTen" style="width:350px;"></td>
              </tr>
              <tr>
                <td>Mã danh mục</td>
                <td><label for="slcMaDM"></label>
                  <select name="slcMaDM" id="slcMaDM">
                     <% for(DanhMucPojo dm : dsDM){ %>
                     <option class="inputdk" value="<%=dm.getMaDanhMuc()%>"><%=dm.getTenDanhMuc()%></option>
                  <%}%>
                </select></td>
              </tr>
              <tr>
                <td>Số lượng</td>
                <td><label for="txtSoLuong"></label>
                <input type="text" name="txtSoLuong" id="txtSoLuong"></td>
              </tr>
              <tr>
                <td>Đơn giá</td>
                <td><label for="txtDonGia"></label>
                <input type="text" name="txtDonGia" id="txtDonGia"></td>
              </tr>
              <tr>
                <td>Mô tả</td>
                <td><label for="txtMoTa"></label>
                <textarea name="txtMoTa" id="txtMoTa" cols="45" rows="5" style="width:350px;" ></textarea></td>
              </tr>
              <tr>
                <td>Hình ảnh</td>
                <td><label for="image"></label>
                <input type="file" name="image" id="image"></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="btnThem" id="btnThem" value="Thêm"></td>
              </tr>
            </table>
              </form>
          </div>
            <div id="right-column">
                
            </div>
        </div>
        <div id="footer">&copy 2011 Sinh viên khoa CNTT</div>
    </div>
</body>
</html>