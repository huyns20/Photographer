/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gallery;
import java.util.List;

/**
 * This interface defines method used to retrieve information from database
 * relating to <code>Gallery</code> object
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public interface GalleryDAO {

    /**
     * Get list Gallery in the top "number" from galery table in database. The
     * result contain a list of <code>entity.Gallery</code> objects
     *
     * @param number the number of Gallery. It is an int number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getTopGallery(int number) throws Exception;

    /**
     * Get Gallery by id from galery table in database. The Gallery has id
     * matches with searched id will be returned. The result contain a Gallery
     * of <code>Gallery</code> objects
     *
     * @param id the id of Gallery. It is an int number
     * @return a Gallery of <code>Gallery</code> objects. It is a
     * <code>entity.Gallery</code> object
     * @throws java.lang.Exception
     */
    public Gallery getGalleryById(int id) throws Exception;

    /**
     * Get list Gallery from galery table in database. All the Gallery matched
     * with id order ascending, between pageSize*(pageIndex - 1) + 1 and
     * pageSize * pageIndex will be returned. The result contain a list of
     * <code>Gallery</code> objects
     *
     * @param pageIndex the index of page. It is an int number
     * @param pageSize the max number of Gallery in each page. It is an int
     * number
     * @return a list of <code>Gallery</code> objects. It is a
     * <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Gallery> getListGalleryWithPaging(int pageIndex, int pageSize)
            throws Exception;

    /**
     * Get number of Gallery from galery table in database. The result contain
     * an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int countNumberOfGallery() throws Exception;

}
