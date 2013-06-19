/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.giohangdao;
import dao.khachhangdao;
import dao.util.MD5Helper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.GioHangPojo;
import pojo.KhachHangPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "dangnhapcontroller", urlPatterns = {"/dangnhapcontroller.do"})
public class dangnhapcontroller extends HttpServlet {

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
            String tenDangNhap = request.getParameter("txtTenDangNhap");
            String matKhau = request.getParameter("txtMatKhau");
           // matKhau = MD5Helper.encryptPass(matKhau);
            KhachHangPojo user = null;
            if (tenDangNhap != null) {
                user = khachhangdao.layKhachHang(tenDangNhap, matKhau);
            }
//            if (user != null) {
//                GioHangPojo gh = (GioHangPojo) session.getAttribute("gioHang");
//                if (gh != null) {
//                    gh = giohangdao.capNhatDonDatHang(gh, user.getTenDangNhap());
//                    session.setAttribute("gioHang", gh);
//                }
//            }
            session.setAttribute("user", user);
            String url = "index.jsp";//(String)session.getAttribute("trangHienTai")+"controller.do";
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
