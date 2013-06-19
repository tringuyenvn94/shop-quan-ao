/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.danhmucdao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pojo.DanhMucPojo;
import pojo.GioHangPojo;
import pojo.KhachHangPojo;

/**
 *
 * @author luctanbinh
 */
public class maincontrol {

    public static HttpServletRequest processRequest(HttpServletRequest request)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
            ArrayList<DanhMucPojo> dsDM = danhmucdao.layDanhMuc();

            ArrayList<String> dsMenu = new ArrayList<String>();
            dsMenu.add("/index");
            dsMenu.add("/tvbanchay");
            dsMenu.add("/dangki");
            ArrayList<String> dsTenMenu = new ArrayList<String>();
            dsTenMenu.add("Trang chủ");
            dsTenMenu.add("TV Bán Chạy");
            dsTenMenu.add("Đăng Kí");

            GioHangPojo gioHang = new GioHangPojo();
            if (session.getAttribute("gioHang") != null) {
                gioHang = (GioHangPojo) session.getAttribute("gioHang");
            }
            int soLuongCT = gioHang.getDsChiTiet().size();
            request.setAttribute("soLuongCT", soLuongCT);
            request.setAttribute("dsDM", dsDM);
            request.setAttribute("user", user);
            request.setAttribute("dsMenu", dsMenu);
            request.setAttribute("dsTenMenu", dsTenMenu);
            
            //RequestDispatcher view = request.getRequestDispatcher("template.jsp");
            //view.forward(request, response);
        } finally {
            return request;
        }
    }
}
