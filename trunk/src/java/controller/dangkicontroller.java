/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

import pojo.KhachHangPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "dangkicontroller", urlPatterns = {"/dangkicontroller.do"})
public class dangkicontroller extends HttpServlet {

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
            
            session.setAttribute("trangHienTai", "/dangki");

            RequestDispatcher view = request.getRequestDispatcher("dangky.jsp");

                String tenDangNhap = request.getParameter("txtTenDangNhap");
                String matKhau = request.getParameter("txtMatKhau");
                //matKhau = MD5Helper.encryptPass(matKhau);
                //String hoTen = request.getParameter("tbHoTen");
                String email = request.getParameter("txtEmail");
                String dienThoai = request.getParameter("txtDienThoai");
                String diaChi = request.getParameter("txtDiaChi");



               KhachHangPojo user = new KhachHangPojo(tenDangNhap, matKhau, tenDangNhap, email, dienThoai, diaChi, false);
                    if (!khachhangdao.kiemTraId(tenDangNhap)) {
                        khachhangdao.themKhachHang(user);
                        session.setAttribute("user", user);
                        view = request.getRequestDispatcher("index.jsp");
                    } else {
                        request.setAttribute("error", "Tên đăng nhập đã tồn tại");
                    }
            
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
