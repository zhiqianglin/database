package DAO;

/**
 * Created by JARVIS on 4/14/17.
 */

import Controller.Helper;
import Model.CityOfficial;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CityOfficialDAO {

    private static final String TABLE = "City_Official";
    private static final String USER_TABLE = "USER";
    private static final String USER_NAME = "username";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String TITLE = "title";



//
//    public static boolean hasUser(String userName) {
//        String queryStatement = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_NAME + " = '" + userName + "'";
//        try {
//            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
//            if (result.size() == 0) {
//                return false;
//            } else {
//                List<String> userInfo = result.get(0);
//                for (String info : userInfo) {
//                    System.out.println(info);
//                }
//                return true;
//            }
//        }
//        catch (Exception e) {
//            Helper.showAlert("Error", e.getMessage());
//        }
//        return false;
//    }
//



    /*
     *  Insert a new cityOfficial tuple
     */
    public static boolean insertCityOfficial(CityOfficial cityOfficial) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + TABLE + "( " +  USER_NAME + ", " + CITY + ", " +
                STATE + ", " + TITLE + ") VALUES ('" + cityOfficial.getUserName() + "', '" + cityOfficial.getCity() + "', '" +
                cityOfficial.getState() + "', '" + cityOfficial.getTitle() +  "')";
        int updatedRows = 0;


        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }

    public static  List<CityOfficial> queryAllPendingAccounts() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + USER_TABLE + " NATURAL JOIN " + TABLE + " WHERE approved is NULL";
        System.out.println(query);

        Statement stmt = null;
        ResultSet rs = null;
        List<CityOfficial> result = new LinkedList<>();

        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        rs = stmt.executeQuery(query);

        // Store result in a list
        while (rs.next()) {
            CityOfficial temp = new CityOfficial(rs.getString("userName"), rs.getString("email"),
                    rs.getString("city"), rs.getString("state"), rs.getString("title"));
            System.out.println(temp);
            result.add(temp);
        }

        // it is a good idea to release resources in a finally{} block in reverse-order of their creation
        // if they are no-longer needed
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore
            stmt = null;
        }
        DBUtil.dbDisconnect();
        return result;
    }

    public static boolean acceptCityOfficialAccount(CityOfficial co) throws SQLException, ClassNotFoundException{
        String update = "UPDATE " + TABLE + " SET APPROVED = TRUE WHERE username = '" + co.getUserName() + "';";
        System.out.println(update);
        Statement stmt = null;
        int updatedRow = 0;


        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        updatedRow = stmt.executeUpdate(update);

        // Store result in a list
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            } // ignore
            stmt = null;
        }
        DBUtil.dbDisconnect();

        if (updatedRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean rejectCityOfficialAccount(CityOfficial co) throws SQLException, ClassNotFoundException{
        String update = "UPDATE " + TABLE + " SET APPROVED = FALSE WHERE username = '" + co.getUserName() + "';";
        System.out.println(update);
        Statement stmt = null;
        int updatedRow = 0;


        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        updatedRow = stmt.executeUpdate(update);

        // Store result in a list
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            } // ignore
            stmt = null;
        }
        DBUtil.dbDisconnect();

        if (updatedRow > 0) {
            return true;
        } else {
            return false;
        }
    }
}
