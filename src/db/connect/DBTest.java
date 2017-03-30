package db.connect;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author home
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        
        DB DB = new DB();
        //Register register = new Register();
        Login login = new Login();
        
       /* // GET USER SCORE IN ARRAYLIST
        
        // getUserScore(id/username)
        List<String> scores = new ArrayList<String>();
        scores = DB.getUserScores("1");
        
        //Print the scores
        System.out.println("Scores:");
        scores.forEach((a)->System.out.println(a));
        
        
        //// ------
        System.out.println("---|---");
        //// ------
        
        // CHECK USERNAME
        Boolean check_username;
        check_username = DB.checkUserName("betlenb");
        
        // PRINT RESULT
        System.out.println("huszerldani szabad? " + check_username);
 
        //// ------
        System.out.println("---|---");
        //// ------
        
        
        // ADD USER
        Map<String, String> user;
        user = new HashMap<>();

        user.put("name", "BoriBetlen");
        user.put("username", "bocika");
        user.put("password", "bocika45");
        
        // PRINT RESULT
        System.out.println("Add user:" + DB.addUser(user));
        
        
        //// ------
        System.out.println("---|---");
        //// ------
        
        
        // LOGIN USER
        Map<String, String> user_login;
        user_login = new HashMap<>();

        user_login.put("username", "huszerldani2");
        user_login.put("password", "nokia11");
        
        // PRINT RESULT
        System.out.println("Login user:" + DB.loginUser(user_login));
*/
        
    }
}
