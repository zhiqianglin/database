package sample.DAO;

/**
 * Created by JARVIS on 4/14/17.
 */
import java.sql.SQLException;
import java.util.*;

public class CityStateDAO {

    private static final String CITY_STATE_TABLE = "city_state";
    private static final String ID = "id";
    private static final String CITY = "city";
    private static final String STATE = "state";

    /*
     *  Retrieve all states
     */
    public static List<List<String>> findAllState() throws SQLException, ClassNotFoundException {
        String query = "SELECT DISTINCT " + STATE + " FROM " + CITY_STATE_TABLE + " ORDER BY " + STATE;
        List<List<String>> result = new LinkedList<>();
        try {
            result = DBUtil.dbExcuteQuery(query);
        } catch (SQLException e){
            System.out.println(e);
        }
        ListIterator<List<String>> iter1 = result.listIterator();
        while(iter1.hasNext()) {
            ListIterator<String> iter2 = iter1.next().listIterator();
            while(iter2.hasNext())
                System.out.println(iter2.next());
        }
        return result;
    }

    /*
     *  Retrieve all city in a given state
     */
    public static List<List<String>> findAllCity(String state) throws SQLException, ClassNotFoundException {
        String query = "SELECT " + CITY + " FROM " + CITY_STATE_TABLE + " WHERE " + STATE + " = '" + state + "' " +
                        "ORDER BY " + CITY;
        List<List<String>> result = new LinkedList<>();
        try {
            result = DBUtil.dbExcuteQuery(query);
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }
}
