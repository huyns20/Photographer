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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Contains a method that calls <code>GalleryDAOImpl</code> to get top 3 of
 * Galleries and <code>ContactDAOImpl</code> to get contact information, then
 * forward to <code>Contact.jsp</code> . To page redirects when system is error
 * or an unannounced error, servlet will directly forward to
 * <code>Error.jsp</code>.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class ContactController extends HttpServlet {

    /**
     * The method calls <code>GalleryDAOImpl</code> to get top 3 of Galleries
     * and <code>ContactDAOImpl</code> to get contact information, then forward
     * to <code>Contact.jsp</code> . When the system is an error or unknown
     * error, servlet will directly forward to <code>Error.jsp</code>.
     *
     * @param request stores attributes:top3, contact, active, errorMessage to
     * send to <code>Contact.jsp</code> and <code>Error.jsp</code>. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            response.setContentType("text/html;charset=UTF-8");
            ContactDAO contactDAO = new ContactDAOImpl();
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            // set top 3 gallery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            // set contact infor
            request.setAttribute("contact", contactDAO.getContact());
            request.setAttribute("active", 4);
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            // when system is errors or unknown errors, Error page will be display     
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
