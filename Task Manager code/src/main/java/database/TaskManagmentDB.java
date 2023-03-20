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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMNA
 */
public class TaskManagmentDB implements DatabaseManagment{
    private Connection con;
    private String dbURL = "jdbc:derby://localhost:1527/Employees";
    private String username = "user1";
    private String password = "user1";
    private Statement stmt ;
    public TaskManagmentDB(){connect();}
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

    public void add_record(String taskid,String title ,String repeat, Date date,Time time, String groupid ) throws SQLException {
        String SQL_INSERT = "INSERT INTO taskdb (taskID, title, taskrepeat,taskDate,TaskTime,groupid) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
        preparedStatement.setString(1, taskid);
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, repeat);
        preparedStatement.setDate(4, date);
        preparedStatement.setTime(5, time);
        preparedStatement.setString(6,groupid);
        int row = preparedStatement.executeUpdate();
        //affected row
        System.out.println(row);
    }
    
    
    @Override
    public void delete_record(String id) {
        String SQL_DELETE = "DELETE FROM TaskDB WHERE taskID=?";
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

    @Override
    public ResultSet get_record(String id) {
        String SQL_SELECT = "SELECT * FROM Taskdb "+" WHERE TaskID='" + id+"'" ;
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;}


public ResultSet get_all(){
    String SQL_SELECT = "SELECT * FROM Taskdb" ;
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
}

public ResultSet range_search (LocalDate start ,LocalDate end){
    String SQL_SELECT = "SELECT * FROM Taskdb where taskdate between '"+start+"' and '"+end+"'" ;
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
}


public void  modify_record(String id ,String title,String repeat ,Date date,Time time, String groupid ) throws SQLException {

     String SQL_UPDATE = "UPDATE taskDB SET Title ='"+title+ "',"+"taskrepeat='"+repeat+"',taskDate='"+date+"',TaskTime ='"+time+"',groupid ='"+groupid+"' WHERE TaskID='"+id+"'";
       
     int row =stmt.executeUpdate(SQL_UPDATE);
}   


}
    

