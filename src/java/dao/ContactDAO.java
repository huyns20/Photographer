/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Contact;

/**
 * This interface defines method used to retrieve information from database
 * relating to <code>Contact</code> object
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public interface ContactDAO {

    /**
     * Get data of Contact from contact table in database. The result contain
     * data of telephone, email, address, city, country, mapUrl of
     * <code>Contact</code> objects
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    public Contact getContact() throws Exception;

    /**
     * Get description of "About me" from contact table in database. The result
     * contains "About me" of <code>java.lang.String</code> object
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    public String getDescriptionOfAboutMe() throws Exception;
}
