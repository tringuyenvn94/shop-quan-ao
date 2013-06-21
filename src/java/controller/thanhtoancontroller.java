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
@WebServlet(name = "thanhtoancontroller", urlPatterns = {"/thanhtoancontroller.do"})
public class thanhtoancontroller extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            request = maincontrol.processRequest(request) ;
            if ("submit".equals(request.getParameter("act"))) {
                String hoTen = request.getParameter("tbHoTen");
                String email = request.getParameter("tbEmail");
                String dienThoai = request.getParameter("tbDienThoai");
                String diaChi = request.getParameter("tbDiaChi");

                KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");

                GioHangPojo gioHang = new GioHangPojo();
                if (session.getAttribute("gioHang") != null) {
                    gioHang = (GioHangPojo) session.getAttribute("gioHang");
                }
//                if (user != null) {
//                    dondathangdao.thanhToan(gioHang.getDonDatHang().getMaDonDatHang());
//                } else {
//                    chitietdondathangdao.themDSChiTietDonDatHang(gioHang.getDsChiTiet(), user);
//                }
                session.setAttribute("gioHang", null);
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            } else {
                request = maincontrol.processRequest(request);

                GioHangPojo gioHang = new GioHangPojo();
                if (session.getAttribute("gioHang") != null) {
                    gioHang = (GioHangPojo) session.getAttribute("gioHang");
                }

                ArrayList<ChiTietDonDatHangPojo> dSCT = new ArrayList<ChiTietDonDatHangPojo>();
                ArrayList<SPPojo> dSSP = new ArrayList<SPPojo>();
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

                RequestDispatcher view = request.getRequestDispatcher("template.jsp");
                view.forward(request, response);
            }
        } finally {
            out.close();
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
