/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.task;

import dao.group.*;
import core.EntityFactory;
import core.Group;
import core.Task;
import database.GroupManagmentDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMNA
 */
public class DAOImplementDerbyJDBC implements Dao{
    private Connection con;
    private String dbURL = "jdbc:derby://localhost:1527/Employees";
    private String username = "user1";
    private String password = "user1";
    private Statement stmt ;

   DAOImplementDerbyJDBC (){connect();}
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
    public Task get_record(String id) {
         String SQL_SELECT = "SELECT * FROM Taskdb "+" WHERE TaskID='" + id+"'" ;
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(SQL_SELECT);
            while(rs.next()){
            Task task = new Task (rs.getString("taskid"), rs.getString("TITLE"), rs.getString("taskrepeat"), rs.getDate("taskdate"), rs.getTime("tasktime"), rs.getString("groupid"));
            return task;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      

    @Override
    public ArrayList<Task> get_all() {
        
        String SQL_SELECT = "SELECT * FROM taskdb" ;
        ResultSet resultSet = null;
        ArrayList<Task> tasks = new  ArrayList<>();
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
             tasks= convertToTask(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;
    }
    
  //convert result set to arraylist of tasks
  public ArrayList<Task> convertToTask(ResultSet rs) throws SQLException{
  ArrayList<Task> tasks = new ArrayList<Task>();
        while(rs.next()){
             EntityFactory factory = new EntityFactory();
             
             Task task = factory.getShape(rs.getString("taskid"), rs.getString("TITLE"), rs.getString("taskrepeat"), rs.getDate("taskdate"), rs.getTime("tasktime"), rs.getString("groupid"));
             tasks.add(task);
         }
         rs.close();
          
    return tasks; }

    @Override
    public void add_record(String taskid,String title ,String repeat, Date date,Time time, String groupid ) {
        try{
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
        }catch (SQLException ex) {
            Logger.getLogger(dao.group.DAOImplementDerbyJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
