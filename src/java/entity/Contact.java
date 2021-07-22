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
 * This class contain entities of Contact. Contain methods which use to get and
 * set all of attributes 2 Constructor with parameter and no parameter.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class Contact {

    private String telephone;
    private String email;
    private String facebookUrl;
    private String twitterUrl;
    private String googleUrl;
    private String about;
    private String address;
    private String city;
    private String country;
    private String mapUrl;
    private String mainImage;
    private String facebookIcon;
    private String twitterIcon;
    private String googleIcon;

    /**
     * Used to initialize Contact with no parameter
     */
    public Contact() {
    }

    /**
     * Used to initialize Contact with its properties as parameters
     *
     * @param telephone the telephone of Contact. It is a
     * <code>java.lang.String</code> object
     * @param email the email of Contact. It is a <code>java.lang.String</code>
     * object
     * @param facebookUrl the Facebook's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param twitterUrl the Twitter's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param googleUrl the Google's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param about the about of Contact. It is a <code>java.lang.String</code>
     * object
     * @param address the address of Contact. It is a
     * <code>java.lang.String</code> object
     * @param city the city of Contact. It is a <code>java.lang.String</code>
     * object
     * @param country the country of Contact. It is a
     * <code>java.lang.String</code> object
     * @param mapUrl the Map's URL of Contact. It is a
     * <code>java.lang.String</code> object
     * @param mainImage the main image of Contact. It is a
     * <code>java.lang.String</code> object
     * @param facebookIcon the Facebook's icon of Contact. It is a
     * <code>java.lang.String</code> object
     * @param twitterIcon the Twitter's icon of Contact. It is a
     * <code>java.lang.String</code> object
     * @param googleIcon the Google's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public Contact(String telephone, String email, String facebookUrl,
            String twitterUrl, String googleUrl, String about, String address,
            String city, String country, String mapUrl, String mainImage,
            String facebookIcon, String twitterIcon, String googleIcon) {
        this.telephone = telephone;
        this.email = email;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.about = about;
        this.address = address;
        this.city = city;
        this.country = country;
        this.mapUrl = mapUrl;
        this.mainImage = mainImage;
        this.facebookIcon = facebookIcon;
        this.twitterIcon = twitterIcon;
        this.googleIcon = googleIcon;
    }

    /**
     * Get value from telephone attribute of <code>Contact</code> objects
     *
     * @return telephone of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set new value for telephone attribute of <code>Contact</code> objects
     *
     * @param telephone the telephone of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get value of attribute email
     *
     * @return email of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new value of attribute email
     *
     * @param email the email of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value of attribute facebookUrl
     *
     * @return facebookUrl of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * Set new value of attribute facebookUrl
     *
     * @param facebookUrl the Facebook's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     * Get value of attribute twitterUrl
     *
     * @return twitterUrl of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * Set new value of attribute twitterUrl
     *
     * @param twitterUrl the Twitter's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * Get value of attribute googleUrl
     *
     * @return googleUrl of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * Set new value of attribute googleUrl
     *
     * @param googleUrl the Google's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * Get value of attribute about
     *
     * @return about of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set new value of attribute about
     *
     * @param about the about of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Get value of attribute address
     *
     * @return address of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set new value of attribute address
     *
     * @param address the address of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get value of attribute city
     *
     * @return city of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getCity() {
        return city;
    }

    /**
     * Set new value of attribute city
     *
     * @param city the city of Contact. It is a <code>java.lang.String</code>
     * object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get value of attribute country
     *
     * @return country of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set new value of attribute country
     *
     * @param country the country of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get value of attribute mapUrl
     *
     * @return mapUrl of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * Set new value of attribute mapUrl
     *
     * @param mapUrl the Map's URL of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    /**
     * Get value of attribute mainImage
     *
     * @return mainImage of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * Set new value of attribute mainImage
     *
     * @param mainImage the main image of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    /**
     * Get value of attribute facebookIcon
     *
     * @return facebookIcon of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getFacebookIcon() {
        return facebookIcon;
    }

    /**
     * Set new value of attribute facebookIcon
     *
     * @param facebookIcon the Facebook's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setFacebookIcon(String facebookIcon) {
        this.facebookIcon = facebookIcon;
    }

    /**
     * Get value of attribute twitterIcon
     *
     * @return twitterIcon of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getTwitterIcon() {
        return twitterIcon;
    }

    /**
     * Set new value of attribute twitterIcon
     *
     * @param twitterIcon the Twitter's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setTwitterIcon(String twitterIcon) {
        this.twitterIcon = twitterIcon;
    }

    /**
     * Get value of attribute googleIcon
     *
     * @return googleIcon of <code>Contact</code> objects. It is a
     * <code>java.lang.String</code> object
     */
    public String getGoogleIcon() {
        return googleIcon;
    }

    /**
     * Set new value of attribute googleIcon
     *
     * @param googleIcon the Google's icon of Contact. It is a
     * <code>java.lang.String</code> object
     */
    public void setGoogleIcon(String googleIcon) {
        this.googleIcon = googleIcon;
    }

}
