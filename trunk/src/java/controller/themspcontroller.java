/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SPDao;
import dao.util.UploadHelper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.SPPojo;

/**
 *
 * @author luctanbinh
 */
@WebServlet(name = "themspcontroller", urlPatterns = {"/themspcontroller"})
public class themspcontroller extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        try {
           HttpSession session = request.getSession();
            response.setContentType("application/vnd.wap.xhtml+xml");
            if (ServletFileUpload.isMultipartContent(request)) {
                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                List fileItemsList = servletFileUpload.parseRequest(request);

                if (!fileItemsList.isEmpty()) {
                    Iterator it = fileItemsList.iterator();
                    String danhmuc = "";
                    String dongia = "";
                    String soluong = "";
                    String mota = "";
                    String hinhanh = "";
                    String ten = "";
                    FileItem imageItem = null;
                    while (it.hasNext()) {
                        FileItem fileItemTemp = (FileItem) it.next();
                        String fieldName = fileItemTemp.getFieldName();
                        if (fileItemTemp.isFormField()) {
                            if ("slcMaDM".equals(fieldName)) {
                                danhmuc = fileItemTemp.getString();
                            } else if ("txtDonGia".equals(fieldName)) {
                                dongia = fileItemTemp.getString();
                            } else if ("txtSoLuong".equals(fieldName)) {
                                soluong = fileItemTemp.getString();
                            } else if ("txtMoTa".equals(fieldName)) {
                                mota = fileItemTemp.getString("UTF-8");
                            } else if ("txtTen".equals(fieldName)) {
                                ten = fileItemTemp.getString("UTF-8");
                            }
                        } else if ("image".equals(fieldName)) {
                            imageItem = fileItemTemp;
                        }
                    }
                    int maDM = Integer.valueOf(danhmuc);
                    int soLuong = 0;
                    if (soluong != null && !soluong.isEmpty()) {
                        soLuong = Integer.valueOf(soluong);
                    }
                    float donGia = 0;
                    if (dongia != null && !dongia.isEmpty()) {
                        donGia = Float.valueOf(dongia);
                    }
                    
                    if (imageItem != null) {
                        String dirName = getServletContext().getRealPath("/") + "imgs\\";
                        UploadHelper.process( imageItem, dirName);
                    }
                    hinhanh = imageItem.getName();
                    SPPojo sp = new SPPojo(maDM, ten, mota, donGia, "imgs/" +hinhanh, soLuong);

                    SPDao.them(sp);
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("themsp.jsp");
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(themspcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(themspcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
