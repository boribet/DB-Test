/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author home
 */
public class DB {
   
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://sql8.freesqldatabase.com";
    static final Integer DB_PORT = 3306;


    //  Database credentials
    static final String DB_USER = "sql8166215";
    static final String DB_PASS = "rins6mGcbF";
    
    static final String DATABASE_NAME = "sql8166215";
    
    
    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;
    
    private static int qe;
   
    private static ResultSet doTheQuery(String query) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
            
        conn = DriverManager.getConnection(DB_URL+":"+DB_PORT+"/"+DATABASE_NAME, DB_USER, DB_PASS);
        st = conn.createStatement();
        rs = st.executeQuery(query);
        
        return rs;
    }
    
    private static int doTheUpdate(String query) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
            
        conn = DriverManager.getConnection(DB_URL+":"+DB_PORT+"/"+DATABASE_NAME, DB_USER, DB_PASS);
        st = conn.createStatement();
        qe = st.executeUpdate(query);
        
        return qe;
    }
    
    private static void closeTheConnection(Boolean update) throws SQLException {
        conn.close();
        st.close();
        
        if (!update) {
            rs.close();
        }

    }
    
    public static List<String> getUserScores(String user) {
         
        List<String> scores = new ArrayList<String>();
        
        
        try {
            
            String query_start = "SELECT scores.score FROM scores JOIN users ON users.id = scores.user_id ";
            String query_end;

            String username;
            username = null;
            
            Integer user_id;
            user_id = null;
            
            try {
                user_id = Integer.parseInt(user);
            } catch (NumberFormatException e) {
                username = user;
            }

            if (username == null) {
                // USER ID
                query_end = "WHERE users.id = '"+user+"'";
            } else {
                // USERNAME
                query_end = "WHERE users.username = '"+user+"'";
            }
            
            
            //user.get("name"); // returns "demo"
            ResultSet result;
            result = doTheQuery(query_start+query_end);

            
            while(result.next()) {
                scores.add(result.getString("score"));
            }
            
            closeTheConnection(false);
            
        } catch(Exception e) {}
         
         return scores;
    }
    
    public static Boolean checkUserName(String username) throws ClassNotFoundException, SQLException {
        //return true;
        
        String query;
        query = "SELECT COUNT(*) FROM users WHERE username = '"+ username +"'";
        
        ResultSet result;
        result = doTheQuery(query);
        
        result.next();
        
        int retrn = result.getInt(1);
        
        closeTheConnection(false);
        
        if (retrn == 0) {
            return true;
        }
        
        return false;
    }
    
    public static Boolean loginUser(Map<String, String> user) throws ClassNotFoundException, SQLException {

        String query;
        query = "SELECT COUNT(*) FROM users WHERE username = '"+ user.get("username") +"' AND password = '"+user.get("password")+"'";
        
        ResultSet result;
        result = doTheQuery(query);
        
        result.next();
        
        int retrn = result.getInt(1);
        
        closeTheConnection(false);
        
        return retrn != 0;
        
    }
    
    public static Boolean addUser(Map<String, String> user) throws ClassNotFoundException, SQLException {
        
        Boolean user_not_exist;
        user_not_exist = checkUserName(user.get("username"));
        
        if (!user_not_exist) {
            return false;
        }
        
        String query = "INSERT INTO `users`(`name`, `username`, `password`) VALUES ('"+user.get("name")+"','"+user.get("username")+"','"+user.get("password")+"')";
        
        int result;
        result = doTheUpdate(query);
        
        closeTheConnection(true);
        
        return result != 0;
        
    }
    

}
