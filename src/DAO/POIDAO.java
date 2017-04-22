package DAO;

/**
 * Created by JARVIS on 4/14/17.
 */

import Controller.Helper;
import Model.CityOfficial;
import Model.POI;
import Model.User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class POIDAO {

    private static final String TABLE = "POI";
    private static final String LOCATION_NAME = "LocationName";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIP_CODE = "ZipCode";
    private static final String FLAG =  "flag";
    private static final String DATE_FLAGGED = "dateFlagged";






    /*
     *  Insert a new cityOfficial tuple
     */
    public static boolean insertPOI(CityOfficial cityOfficial) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + TABLE + "( " +  LOCATION_NAME + ", " + CITY + ", " +
                STATE + ", " + ZIP_CODE + ") VALUES ('" + cityOfficial.getUserName() + "', '" + cityOfficial.getCity() + "', '" +
                cityOfficial.getState() + "', '" + cityOfficial.getTitle() +  "')";
        int updatedRows = 0;


        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }


//    public static POI findPOI(String locationName) {
//        String queryStatement = "SELECT * FROM " + TABLE + " WHERE " + LOCATION_NAME + " = '" + locationName + "'";
//        POI curr = null;
//        try {
//            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);
//            if (result.size() == 0) {
//                System.out.println("Not found");
//            } else {
//                List<String> userInfo = result.get(0);
//                System.out.println(userInfo.size());
//                for (String info : userInfo) {
//                    System.out.println(info);
//                }
//
//            }
//        }
//        catch (Exception e) {
//            Helper.showAlert("Error", e.getMessage());
//            return curr;
//        }
//
//        return curr;
//    }


    public static POI queryPOI(String locationName) throws SQLException, ClassNotFoundException {
        String queryStatement = "SELECT * FROM " + TABLE + " WHERE " + LOCATION_NAME + " = '" + locationName + "'";
        Statement stmt = null;
        ResultSet rs = null;
//        ResultSetMetaData rsmd = null;
        List<POI> result = new LinkedList<>();

        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        rs = stmt.executeQuery(queryStatement);
//            rsmd = rs.getMetaData();

        // Store result in a list
        while (rs.next()) {
            POI curr = new POI(rs.getString("LocationName"), rs.getString("City"),
                    rs.getString("State"), rs.getString("zipCode"), rs.getBoolean("flag"),
                    rs.getDate("dateFlagged"));
//                System.out.println(curr.getLocationName() + "," + curr.getCity() + curr.getState() + curr.getZipCode() + curr.getDateFlagged() + curr.isFlagged());
            result.add(curr);
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

        return null;
    }


    public static List<String> queryAllLocationNames() throws SQLException, ClassNotFoundException {
        String query = "SELECT LocationName FROM " + TABLE + ";";

        Statement stmt = null;
        ResultSet rs = null;
        List<String> result = new LinkedList<>();

        DBUtil.dbConnection();
        stmt = DBUtil.con.createStatement();
        rs = stmt.executeQuery(query);

        // Store result in a list
        while (rs.next()) {
            result.add(rs.getString("LocationName"));
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



    public static boolean insertLocation(POI curr) throws SQLException, ClassNotFoundException{
        String insertStatement = "INSERT INTO " + TABLE + "( " +  LOCATION_NAME + ", " + CITY + ", " +
                STATE + ", " + ZIP_CODE + "," + FLAG + "," + DATE_FLAGGED + ") VALUES ('" + curr.getLocationName() + "', '" + curr.getCity() + "', '" +
                curr.getState() + "', '" + curr.getZipCode() + "'," + curr.isFlagged() +  "," + curr.getDateFlagged() + ")";

        System.out.println(insertStatement);
        int updatedRows = 0;


        updatedRows = DBUtil.dbExecuteUpdate(insertStatement);

        if (updatedRows != 0)
            return true;
        else
            return false;
    }
}
