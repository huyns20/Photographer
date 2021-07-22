/*
 * Copyright(C) 2021,  huynshe141505.
 * J3.L.P0017
 * Java Web
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 *
 */
package dao.impl;

import context.DBContext;
import dao.ContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving data from contact table in database.
 * The method will return an object of the class
 * <code> java.lang.Exception</code> when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class ContactDAOImpl extends DBContext implements ContactDAO {

    /**
     * Method uses to get information of Contact from contact table in database.
     * The first contact in contact table will be return. The result contains
     * data of telephone, email, address, city, country, mapUrl of
     * <code>Contact</code> objects
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top 1 * from contact";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setTelephone(rs.getString("telephone"));
                contact.setEmail(rs.getString("email"));
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setMapUrl(rs.getString("map_url"));
                return contact;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Method uses to get description of "About me" from contact table in
     * database. The first About me in contact table will be return. The result
     * contains About me of <code>java.lang.String</code> object
     *
     * @return a contact of <code>Contact</code> objects. It is a
     * <code>entity.Contact</code> object
     * @throws java.lang.Exception
     */
    @Override
    public String getDescriptionOfAboutMe() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String about = "";
        try {
            String sql = "select top 1 about from contact";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                about = rs.getString(1);
                return about;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }
}
