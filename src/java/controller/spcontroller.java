/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SPDao;
import dao.giohangdao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.GioHangPojo;
import pojo.KhachHangPojo;
import pojo.SPPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "spcontroller", urlPatterns = {"/spcontroller"})
public class spcontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try {
            KhachHangPojo user = (KhachHangPojo) session.getAttribute("user");
            SPPojo sp = new SPPojo();
            String ma = request.getParameter("id");
            int maSP = 0;
            if (ma != null) {
                maSP = Integer.parseInt(ma);
                sp = SPDao.laySP(maSP);
            }

            GioHangPojo gioHang = new GioHangPojo();
            if (session.getAttribute("GioHang") != null) {
                gioHang = (GioHangPojo) session.getAttribute("GioHang");
            }
            gioHang = giohangdao.ThemSP(sp, 1, gioHang, user);
            session.setAttribute("GioHang", gioHang);
            RequestDispatcher view = request.getRequestDispatcher("giohang.jsp");
            view.forward(request, response);
        } finally {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
