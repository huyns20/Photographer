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
import dao.PageviewDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class has methods for retrieving and update data to view table in
 * database. The method will return an object of the class
 * <code> java.lang.Exception</code> when there is any error querying the data.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public class PageviewDAOImpl extends DBContext implements PageviewDAO {

    /**
     * Find the number of views page from view table in database. The result
     * contain an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    @Override
    public int getNumberOfViewsPage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from [view]";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Update the number of views page from view table in database. The number
     * of views page will be increased by 1 every time accessed the page
     *
     * @throws java.lang.Exception
     */
    @Override
    public void updateNumberOfViewsPage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE [view] SET numberOfViewsPage = numberOfViewsPage + 1";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
