/*
 * Copyright(C) 2021,  huynshe141505.
 * J3.L.P0017
 * Java Web
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 10/7/2021            1.0              HUYNS          Fix code and comment
 *
 *
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.ImageDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import dao.impl.ImageDAOImpl;
import entity.Image;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains method that calls <code>GalleryDAOImpl</code> and
 * <code>ImageDAOImpl</code> to get Gallery by ID, top 3 Galleries, top 1 image
 * of Gallery, list images of a Gallery, then forward to
 * <code>Gallery.jsp</code>. When system is error or an unannounced error, the
 * class will redirect to an <code>Error.jsp</code>.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class GalleryController extends HttpServlet {

    /**
     * This method calls <code>GalleryDAOImpl</code> and
     * <code>ImageDAOImpl</code> to get Gallery by ID, top 3 Galleries, top 1
     * image of Gallery, list images of a Gallery, then forward to
     * <code>Gallery.jsp</code>. When system is error or an unannounced error,
     * the class will redirect to an <code>Error.jsp</code>.
     *
     * @param request stores attributes: top1Gallery, listImage, index, maxPage,
     * galeryID, totalRecord, galery, top3, contact, active, error to send to
     * <code>Gallery.jsp</code> and <code>Error.jsp</code> JSP. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            ImageDAO imageDAO = new ImageDAOImpl();
            ContactDAO contactDAO = new ContactDAOImpl();
            String galleryId = request.getParameter("galeryId");
            int galleryID = 0;
            galleryID = Integer.parseInt(galleryId);
            int totalImageEachPage = 8;
            // Count total result 
            int totalRecord = imageDAO.countImage(galleryID);
            int totalPage = totalRecord / totalImageEachPage;
            // create one more page to contain Gallery
            if ((totalRecord % totalImageEachPage) != 0) {
                totalPage++;
            }
            String pageIndex = request.getParameter("index");
            int index = 0;
            // check index page
            if (pageIndex != null) {
                index = Integer.parseInt(pageIndex);
            } else {
                index = 1;
            }
            int imageId = 0;
            imageId = imageDAO.getTop1ImageGallery(galleryID).getId();
            request.setAttribute("top1Gallery", imageDAO.getImageByID(imageId, galleryID));
            //get list image with paging 
            List<Image> imageList = imageDAO.getListImageWithPaging(galleryID, index, totalImageEachPage);
            request.setAttribute("listImage", imageList);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", totalPage);
            request.setAttribute("galeryID", galleryID);
            request.setAttribute("totalRecord", totalRecord);
            request.setAttribute("galery", galleryDAO.getGalleryById(galleryID));
            //get top 3 galery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            //get contact infor
            request.setAttribute("contact", contactDAO.getContact());
            request.setAttribute("active", galleryId);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
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
