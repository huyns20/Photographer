/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;
import java.util.List;

/**
 * This interface defines method used to retrieve information from database
 * relating to <code>Image</code> object
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public interface ImageDAO {

    /**
     * Get number of Image from image table in database. All the Image matches
     * has Gallery ID matches with searched id will be returned. The result
     * contain an int number.
     *
     * @param id the id of a Gallery. It is an int number
     * @return an int number <code>entity.Digital</code> object
     * @throws java.lang.Exception
     */
    public int countImage(int id) throws Exception;

    /**
     * Get Image by Gallery ID from image table in database. The first Image has
     * Gallery ID matched with searched ID will be returned. The result contains
     * Image URL of <code>java.lang.String</code> object
     *
     * @param id the id of a Gallery. It is an int number
     * @return a image URL of <code>Image</code> objects. It is a
     * <code>java.lang.String</code> object
     * @throws java.lang.Exception
     */
    public String getImageByGalleryID(int id) throws Exception;

    /**
     * Get list Image by Gallery ID from image table in database. All the Image
     * matched with id order ascending, Gallery ID matched with searched ID and
     * between pageSize*(pageIndex - 1) + 1 and pageSize * pageIndex will be
     * returned. The result contain a list of <code>Image</code> objects
     *
     * @param galleryID the id of a Gallery. It is an int number
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Image</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Image> getListImageWithPaging(int galleryID, int pageIndex, int pageSize)
            throws Exception;

    /**
     * Get Image by id from image table in database. The Image has id matches
     * with searched Image ID and Gallery ID will be returned. The result
     * contain a Image of <code>Image</code> objects
     *
     * @param imageId the id of Image. It is an int number
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    public Image getImageByID(int imageId, int galleryId) throws Exception;

    /**
     * Get Image by Gallery ID from image table in database. The first Image has
     * Gallery id matches with searched id will be returned. The result contains
     * a image of <code>entity.Image</code> objects
     *
     * @param galleryId the id of Gallery. It is an int number
     * @return a Image of <code>Image</code> objects. It is a
     * <code>entity.Image</code> object
     * @throws java.lang.Exception
     */
    public Image getTop1ImageGallery(int galleryId) throws Exception;
}
