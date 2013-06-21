/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.giohangdao;
import dao.SPDao;
import javax.servlet.http.*;
import pojo.GioHangPojo;
import pojo.KhachHangPojo;
import pojo.SPPojo;

/**
 *
 * @author luctanbinh
 */
public class xulydatmua {

    public static void xuLy(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
        SPPojo tv = new SPPojo();
        String ma = request.getParameter("maSP");
        int maSP = 0;
        if (ma != null) {
            maSP = Integer.parseInt(ma);
            tv = SPDao.laySP(maSP);
        }

        GioHangPojo gioHang = new GioHangPojo();
        if (session.getAttribute("gioHang") != null) {
            gioHang = (GioHangPojo) session.getAttribute("gioHang");
        }
        gioHang = giohangdao.ThemSP(tv, 1, gioHang, user);
        int soLuongCT = gioHang.getDsChiTiet().size() ;
        session.setAttribute("gioHang", gioHang);
        request.setAttribute("soLuongCT", soLuongCT);
    }
}
