/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AMNA
 */
public class Checkchanges {
    public static void main(String[] args) throws SQLException {
         GroupManagmentDB dt = new GroupManagmentDB();      
        //dt.add_record("5","studeydm home works ", "This group is for school homeworks includeing kkkkdk");
        //dt.add_record("4","work self study ", null);
        //dt.modify_record("12", "school home works ", "amna is important ");
        //dt.delete_record("12");
        try (ResultSet rs = dt.get_all()) {
            while(rs.next()){
                //Display values
                System.out.println("ID: " + rs.getString("ID"));
                System.out.println(", Name: " + rs.getString("NAME"));
                System.out.println(", Description : " + rs.getString("DESCRIPTION"));
                
            }
            
            System.out.println("____________");
           ResultSet rss = dt.get_record("3");
            while(rss.next()){
                //Display values
                System.out.println("ID: " + rss.getString("ID"));
                System.out.println(", Name: " + rss.getString("NAME"));
                System.out.println(", Description : " + rss.getString("DESCRIPTION"));
                
            }
            
        }
    }
    
    }

