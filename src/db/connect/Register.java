/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connect;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author zceibet
 */
public class Register {

    Scanner scan = new Scanner(System.in);
   
    private String name; 
    private String username; 
    private String password;   

    public Register() throws ClassNotFoundException, SQLException{
   
        System.out.println("Enter your real name: ");
        username = scan.nextLine();
        
        System.out.println("Enter a new username: ");
        password = scan.nextLine();
        
        // CHECK USERNAME until its false (taken) keep asking for a new one

        Boolean check_username;
        check_username = DB.checkUserName(username);
        
        while(check_username==false)
        {
         System.out.println("That username is already taken, please enter a new one: ");
         username = scan.nextLine();
         check_username = DB.checkUserName(username);
        }
        
        //Ask for a password for the new username
        
        System.out.println("Enter a new pasword: ");
        name = scan.nextLine();
        
        //ADD THE NEW USER TO THE SQL DATABASE
        
        Map<String, String> user;
        user = new HashMap<>();

        user.put("name", name);
        user.put("username", username);
        user.put("password", password);
        
        // PRINT RESULT this we wont need when this thing works
        
        System.out.println("Add user:" + DB.addUser(user));
        
    }
}
