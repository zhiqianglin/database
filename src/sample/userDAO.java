package sample;

/**
 * Created by JARVIS on 4/14/17.
 */
import java.sql.SQLException;
import java.util.*;

public class userDAO {
    // search by username
    private static final String USER_TABLE = "user";
    private static final String USER_NAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String USER_TYPE = "usertype";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String TITLE = "title";

    /*
     *  Search user by username
     */
    public static void findByUsername (String username) throws SQLException, ClassNotFoundException {
        String queryStatement = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_NAME + " = " + username;

        try {
            List<List<String>> result = DBUtil.dbExcuteQuery(queryStatement);

            ListIterator<List<String>> iter1 = result.listIterator();
            while(iter1.hasNext()) {
                ListIterator<String> iter2 = iter1.next().listIterator();
                while(iter2.hasNext())
                    System.out.println(iter2.next());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /*
     *  Insert a new user
     */
    public static String insertUser(User newUser) throws SQLException, ClassNotFoundException {
        String insertStatement = "INSERT INTO " + USER_TABLE + "( " +  USER_NAME + ", " + EMAIL + ", " +
                            PASSWORD + ", " + USER_TYPE + ", " + CITY + ", " + STATE + ", " + TITLE +
                            ") VALUES ('" + newUser.getUserName() + "', '" + newUser.getEmail() + "', '" +
                            newUser.getPassword() + "', '" + newUser.getUserType() + "', '" + newUser.getCity()
                            + "', '" + newUser.getState() + "', '" + newUser.getTitle() + "')";
        int updatedRows = 0;

        try {
            updatedRows = DBUtil.dbExecuteUpdate(insertStatement);
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (updatedRows != 0)
            return "New record added";
        else
            return "Invalid input. Please double check!";
    }
}
