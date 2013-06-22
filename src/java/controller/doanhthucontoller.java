/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ThongKeDao;
import dao.danhmucdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.DanhMucPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "doanhthucontoller", urlPatterns = {"/doanhthucontoller"})
public class doanhthucontoller extends HttpServlet {

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
        try {
           
           String strThang = request.getParameter("optsThang");
           String strNam = request.getParameter("optsNam");
           int thang = Integer.valueOf(strThang);
           int nam = Integer.valueOf(strNam);
           Calendar c = Calendar.getInstance();
           c.set(nam, thang-1, 1);
           Date from = c.getTime();
           int daysOfM = c.getActualMaximum(Calendar.DAY_OF_MONTH);
           c.set(nam, thang-1, daysOfM);
           Date to = c.getTime();
           List<DanhMucPojo> lstDM = danhmucdao.layDanhMuc();
           
           List<Float> lstGiaTri = new ArrayList<Float>();
           for(DanhMucPojo dm : lstDM){
               float gt = ThongKeDao.layGiaTriDDH(dm.getMaDanhMuc(), from, to);
               lstGiaTri.add(gt);
           }
           request.setAttribute("lstGiaTri", lstGiaTri);
           request.setAttribute("lstDM", lstDM);
           request.setAttribute("thang", thang);
           request.setAttribute("nam", nam);
           RequestDispatcher view = request.getRequestDispatcher("thongke.jsp?submit=doanhthu");
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
