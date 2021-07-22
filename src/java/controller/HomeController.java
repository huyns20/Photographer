/*
 * Copyright(C) 2021,  huynshe141505.
 * J3.L.P0017
 * Java Web
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 10/7/2021            1.0              HUYNS          Fix code and comment
 *
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import entity.Gallery;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains method that calls <code>GalleryDAOImpl</code> to get list
 * paging Gallery, total of Gallery and top 3 Galleries, then forward to
 * <code>HomePage.jsp</code>. When system is error or an unannounced error, the
 * class will redirect to an <code>Error.jsp</code>
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class HomeController extends HttpServlet {

    /**
     * This method calls <code>GalleryDAOImpl</code> to get list paging Gallery,
     * total of Gallery and top 3 Galleries, then forward to
     * <code>HomePage.jsp</code>. When system is error or an unannounced error,
     * the class will redirect to an <code>Error.jsp</code>
     *
     * @param request stores attributes: listGalery, index, maxPage,
     * totalRecord, top3, contact, error, active to send to
     * <code>HomePage.jsp</code> and <code>Error.jsp</code>. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response respond to an HTTP Request to the browser. It is a
     * <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ContactDAO contactDAO = new ContactDAOImpl();
            // number of Gallery in each page
            int totalGalleryEachPage = 3;
            String pageIndex = request.getParameter("index");
            int index = 0;
            // check index page
            if (pageIndex != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                } catch (Exception e) {
                    request.setAttribute("error", "This page is invalid!!");
                }
            } else {
                index = 1;
            }
            // Count total result
            int totalRecord = galleryDAO.countNumberOfGallery();
            // No result
            if (totalRecord <= 0) {
                request.setAttribute("error", "No result!!");
            }
            int totalPage = totalRecord / totalGalleryEachPage;
            // create one more page to contain Gallery
            if ((totalRecord % totalGalleryEachPage) != 0) {
                totalPage++;
            }
            //get list galery with paging
            List<Gallery> listGallery = galleryDAO.getListGalleryWithPaging(index, totalGalleryEachPage);
            // set list gallery
            request.setAttribute("listGalery", listGallery);
            // set index of page
            request.setAttribute("index", index);
            // set number of page
            request.setAttribute("maxPage", totalPage);
            // set number of Gallery
            request.setAttribute("totalRecord", totalRecord);
            // set top 3 gallery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            // set contact infor
            request.setAttribute("about", contactDAO.getDescriptionOfAboutMe());
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            //when system is errors or unknown errors, Error page will be display     
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
