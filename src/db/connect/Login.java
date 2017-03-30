/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author home
 */
public class Login {
    Scanner scan = new Scanner(System.in);
    
    private String username; 
    private String password;  
    private String action; 
    
    public Login() throws ClassNotFoundException, SQLException, IOException
    {
        System.out.println("Enter your username: ");
        username = scan.nextLine();
        
        System.out.println("Enter your password: ");
        password = scan.nextLine();
        
        Map<String, String> user_login;
        user_login = new HashMap<>();

        user_login.put("username", username);
        user_login.put("password", password);
        
        // PRINT RESULT just for testing
        System.out.println("Login user:" + DB.loginUser(user_login));
        
        
        // untill user is not logged in keep asking if they want to Register instead
        
        while(DB.loginUser(user_login)==false)
        {
            System.out.print("Your login was unsuccesful, please press L to try again or R to register.");
            action = scan.nextLine();
            
            switch(action)
            {
                case("L"):
                    Login login1 = new Login();
                    break;
                    
                case("R"):
                    Register register1 = new Register();
                    break;
            }
        }
        
        // if all is well start the game
        Quizzmain game = new Quizzmain();
    }
    
}
