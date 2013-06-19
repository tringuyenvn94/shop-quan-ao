/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.binhluandao;
import dao.SPDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.binhluanpojo;
import pojo.KhachHangPojo;
import pojo.SPPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "chitietcontroller", urlPatterns = {"/chitietcontroller.do"})
public class chitietcontroller extends HttpServlet {

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
            request = maincontrol.processRequest(request) ;
            SPPojo tv = new SPPojo();
            String ma = request.getParameter("id");
            int maSP = 0;
            if (ma != null) {
                maSP = Integer.parseInt(ma);
                tv = SPDao.laySP(maSP);
            }
            request.setAttribute("tv", tv);
            
            if("Submit".equals(request.getParameter("act"))){
                String noiDung = request.getParameter("txtnoidung") ;
                KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
                binhluandao.themBinhLuan(noiDung, maSP, user.getTenDangNhap());
            }
            ArrayList<binhluanpojo> dSBL = binhluandao.laySP(maSP) ;
            request.setAttribute("dSBL", dSBL);
            RequestDispatcher view = request.getRequestDispatcher("chitiet.jsp");
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
