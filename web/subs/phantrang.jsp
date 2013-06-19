<%-- 
    Document   : phantrang
    Created on : Sep 27, 2011, 12:48:45 AM
    Author     : luctanbinh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer trang = (Integer)request.getAttribute("trang");
    Integer soTrang = (Integer)request.getAttribute("soTrang");
%>
<!DOCTYPE html>
<div id="phantrang">
                    	<font style="color:#666;font-size:14px;">Trang:</font>
                        <%for(int i = 1; i <= soTrang; i++){
                            if(i == trang){%>
                            <a class="tranghientai" href="index.jsp?trang=<%=i%>"><%=i%></a>
                            <%}else{%>
                            <a class="ovuong" href="index.jsp?trang=<%=i%>"><%=i%></a>
                            <%}
                        }%>

</div>