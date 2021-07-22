/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 * This interface defines method used to retrieve information from database
 * relating to number of views page
 * <p>
 * Bugs: None
 *
 * @author Nguyen Sy Huy
 */
public interface PageviewDAO {

    /**
     * Get number of views page from view table in database. The result contain
     * an int number
     *
     * @return an int number
     * @throws java.lang.Exception
     */
    public int getNumberOfViewsPage() throws Exception;

    /**
     * Update the number of views page from view table in database. The number
     * of views page will be increased by 1 every time accessed the page
     *
     * @throws java.lang.Exception
     */
    public void updateNumberOfViewsPage() throws Exception;
}
