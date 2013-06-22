<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link  href="style/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="main">
        <div id="header">Shop Quần Áo
          <ul id="top-navigation">
   <li><a href="themsp.jsp">Thêm sản phẩm</a></li>
                <li><a href="themdm.jsp" class="active">Thêm danh mục</a></li>
                <li><a href="thongke.jsp" >Thống kê</a></li>
                <li><a href="index.jsp" >Home</a></li>
            </ul>
        </div>
        <div id="middle">
          <div id="center-column">
              <form name="frmThemDM" method="POST" action="themdmcontroller">
            <table width="628" >
              <tr>
                <td width="128">Tên danh mục</td>
                <td width="488"><label for="txtTen"></label>
                <input type="text" name="txtTen" id="txtTen" ></td>
              </tr>
              <tr>
                <td>Xuất xứ</td>
                <td><label for="slcMaDM"></label>
                  <label for="txtXuatXu"></label>
                <input type="text" name="txtXuatXu" id="txtXuatXu"></td>
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
