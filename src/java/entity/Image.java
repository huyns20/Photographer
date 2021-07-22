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
package entity;

/**
 * This class contain entities of Image. Contain methods which use to get and
 * set all of attributes 2 Constructor with parameter and no parameter
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class Image {

    private int id;
    private int galleryId;
    private String imageUrl;

    /**
     * Used to initialize Image with no parameter
     */
    public Image() {
    }

    /**
     * Constructor has parameters used to initialize an object with information
     * passed in Parameters that need to be passed include id, galleryId,
     * imageUrl
     *
     * @param id the id of Image. It is an int number
     * @param galleryId the id of Gallery. It is an int number
     * @param imageUrl the URL of Image. It is a <code>java.lang.String</code>
     * object
     */
    public Image(int id, int galleryId, String imageUrl) {
        this.id = id;
        this.galleryId = galleryId;
        this.imageUrl = imageUrl;
    }

    /**
     * Get value of attribute id
     *
     * @return id of <code>Image</code> objects. It is an int number
     */
    public int getId() {
        return id;
    }

    /**
     * Set new value of attribute id
     *
     * @param id the id of image. It is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value of attribute galleryId
     *
     * @return galleryId of <code>Image</code> objects. It is an int number
     */
    public int getGalleryId() {
        return galleryId;
    }

    /**
     * Set new value of attribute galleryId
     *
     * @param galleryId the id of gallery. It is an int number
     */
    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    /**
     * Get value of attribute imageUrl
     *
     * @return imageUrl of <code>Image</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Set new value of attribute imageUrl
     *
     * @param imageUrl the URL of image. It is a <code>java.lang.String</code>
     * object
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
