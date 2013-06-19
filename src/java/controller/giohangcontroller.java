/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.*;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "giohangcontroller", urlPatterns = {"/giohangcontroller.do"})
public class giohangcontroller extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            request = maincontrol.processRequest(request);

            GioHangPojo gioHang = new GioHangPojo();
            if (request.getParameter("id") != null) {
                String id = request.getParameter("id");
                int maDh = 0;
                maDh = Integer.parseInt(id);
                gioHang = giohangdao.layGioHang(maDh);
            } else {
                if (session.getAttribute("gioHang") != null) {
                    gioHang = (GioHangPojo) session.getAttribute("gioHang");
                }
            }
            session.setAttribute("trangHienTai", "/giohang");

            ArrayList<SPPojo> dSSP = new ArrayList<SPPojo>();
            ArrayList<ChiTietDonDatHangPojo> dSCT = new ArrayList<ChiTietDonDatHangPojo>();
            for (int i = 0; i < gioHang.getDsChiTiet().size(); i++) {
                ChiTietDonDatHangPojo ct = gioHang.getDsChiTiet().get(i);
                SPPojo tv = SPDao.laySP(ct.getMaSP());
                dSSP.add(tv);
                dSCT.add(ct);
            }
            ThamSoPojo thamSo1 = thamsodao.layThamSo("CVC");
            ThamSoPojo thamSo2 = thamsodao.layThamSo("TGTGT");
            float cvc = Float.parseFloat(thamSo1.getGiaTri()) * 100;
            float gtgt = Float.parseFloat(thamSo2.getGiaTri()) * 100;
            int iCvc = (int) cvc;
            int Gtgt = (int) gtgt;

            float tt = gioHang.getTongTien();
            tt += tt * cvc / 100 + tt * gtgt / 100;
            int soLuongCT = gioHang.getDsChiTiet().size();
            request.setAttribute("iCvc", iCvc);
            request.setAttribute("Gtgt", Gtgt);
            request.setAttribute("tt", tt);
            request.setAttribute("dSCT", dSCT);
            request.setAttribute("dSSP", dSSP);
            request.setAttribute("soLuongCT", soLuongCT);
            session.setAttribute("gioHang", gioHang);

            RequestDispatcher view = request.getRequestDispatcher("giohang.jsp");

            if ("submit".equals(request.getParameter("act"))) {
                KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");

                try {
                    if (gioHang != null) {
                        for (int i = 0; i < gioHang.getDsChiTiet().size(); i++) {
                            ChiTietDonDatHangPojo ct = gioHang.getDsChiTiet().get(i);
                            int soLuong = 1;
                            String name = "tbSoLuong" + i;
                            String strSL = request.getParameter(name);
                            if (strSL != null) {

                                soLuong = Integer.parseInt(strSL);
                            }
                            float gia = SPDao.layDonGia(ct.getMaSP());
                            ct.setSoLuong(soLuong);
                            if (user != null) {
                                chitietdondathangdao.capNhat(ct.getMaChiTiet(), soLuong);
                            }
                        }
                    }
                } catch (Exception e) {
                    request.setAttribute("error", "1");
                    view.forward(request, response);
                }
            } else if ("xoa".equals(request.getParameter("act"))) {
                KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");

                String strIndex = (String) session.getAttribute("Index");
                int index = Integer.parseInt(strIndex);

                int maCT = gioHang.getDsChiTiet().get(index).getMaChiTiet();
                gioHang.getDsChiTiet().remove(index);
                if (user != null) {
                    chitietdondathangdao.xoa(maCT);
                }
            }
            session.setAttribute("gioHang", gioHang);
            view.forward(request, response);
        } finally {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
