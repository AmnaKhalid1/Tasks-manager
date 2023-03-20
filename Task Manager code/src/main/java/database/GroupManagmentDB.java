/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMNA
 */
public class GroupManagmentDB implements DatabaseManagment{
    private Connection con;
    private String dbURL = "jdbc:derby://localhost:1527/Employees";
    private String username = "user1";
    private String password = "user1";
    private Statement stmt ;

    public GroupManagmentDB(){connect();}
    @Override
    public void delete_record(String id) {
        String SQL_DELETE = "DELETE FROM GROUPDB WHERE ID=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, id);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ResultSet get_record(String id) {
        String SQL_SELECT = "SELECT * FROM GROUPDB "+" WHERE ID='" + id+"'" ;
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;}
    
    public void modify_record(String group_id,String name ,String description) throws SQLException{
        String SQL_UPDATE = "UPDATE GROUPDB SET NAME='" + name + "',DESCRIPTION='"+description+"' WHERE ID= '" + group_id+"'" ;
        int row =stmt.executeUpdate(SQL_UPDATE);
        
    
    }
    
    
    public void add_record(String group_id,String name ,String description) throws SQLException {
        String SQL_INSERT = "INSERT INTO GROUPDB (ID, NAME, DESCRIPTION) VALUES (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
        preparedStatement.setString(1, group_id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, description);
        int row = preparedStatement.executeUpdate();
        //affected row
        System.out.println(row);
    }
    public ResultSet get_all(){
    String SQL_SELECT = "SELECT * FROM groupdb" ;
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
}
    
    
    @Override
    public void connect() {

    try {
         con = DriverManager.getConnection(dbURL, username, password);
         stmt = con.createStatement();
         if (con!= null) 
         {
         System.out.println("Connected");
         }
        }   catch (SQLException ex) {
                Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
}

}
