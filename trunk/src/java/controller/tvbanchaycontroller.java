/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SPDao;
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
import pojo.SPPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "tvbanchaycontroller", urlPatterns = {"/tvbanchaycontroller.do"})
public class tvbanchaycontroller extends HttpServlet {

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

            int trang = 1;
            int soLuongTrenTrang = 10;
            String strTrang = request.getParameter("trang");
            if (strTrang != null) {
                trang = Integer.parseInt(strTrang);
            }
            String strSoLuong = request.getParameter("soLuongTrenTrang");
            if (strSoLuong != null) {
                soLuongTrenTrang = Integer.parseInt(strSoLuong);
            }
            ArrayList<SPPojo> dsSP = SPDao.layDSSPBanChay(trang, soLuongTrenTrang);
            if (dsSP == null) {
                dsSP = new ArrayList<SPPojo>();
            }
            int soTrang = SPDao.tinhSoTrangDSSPBanChay(soLuongTrenTrang);

            request.setAttribute("trang", trang);
            request.setAttribute("soLuongTrenTrang", soLuongTrenTrang);
            request.setAttribute("soTrang", soTrang);
            request.setAttribute("dsSP", dsSP);

            session.setAttribute("trangHienTai", "/tvbanchay");
            if("datmua".equals(request.getParameter("act"))){
                xulydatmua.xuLy(request, response);
            }
            RequestDispatcher view = request.getRequestDispatcher("tvbanchay.jsp");
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
