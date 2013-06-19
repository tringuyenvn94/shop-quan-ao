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
@WebServlet(name = "lichsumuahangcontroller", urlPatterns = {"/lichsumuahangcontroller.do"})
public class lichsumuahangcontroller extends HttpServlet {

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
            request = maincontrol.processRequest(request);
            
            KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
            ArrayList<DonDatHangPojo> dSDH = new ArrayList<DonDatHangPojo>();
            float[] dSTongTien = new float[1];
            String[] dSTT = new String[0];
            if (user != null) {
                dSDH = dondathangdao.layDSDonHang(user.getTenDangNhap());
                dSTongTien = new float[dSDH.size()];
                dSTT = new String[dSDH.size()] ;
                for (int i = 0; i < dSDH.size(); i++) {
                    //dSTongTien[i] = chitietdondathangdao.tinhTongTien(dSDH.get(i).getMaDonDatHang());
                    dSTT[i] = tinhtrangdondathangdao.layTenTinhTrang(dSDH.get(i).getMaTinhTrang()) ;
                }
            }
            request.setAttribute("dSDH", dSDH);
            request.setAttribute("dSTongTien", dSTongTien);
            
            session.setAttribute("user", user);
            session.setAttribute("trangHienTai", "/lichsumuahang");
            
            RequestDispatcher view = request.getRequestDispatcher("lichsumuahang.jsp");
            view.forward(request, response);
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
