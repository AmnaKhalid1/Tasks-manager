/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.group;

import core.EntityFactory;
import core.Group;
import database.GroupManagmentDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

   public DAOImplementDerbyJDBC(){connect();}
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

    @Override
    public Group get_record(String id) {
        String SQL_SELECT = "SELECT * FROM GROUPDB "+" WHERE ID='" + id+"'" ;
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(SQL_SELECT);
            while(rs.next()){
             EntityFactory factory = new EntityFactory();
             
             Group group = factory.getShape(rs.getString("id"), rs.getString("name"), rs.getString("description"));
             
             return group;
         }
         rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    

    @Override
    public ArrayList<Group> get_all() {
        
        String SQL_SELECT = "SELECT * FROM groupdb" ;
        ResultSet resultSet = null;
        ArrayList<Group> groups = new  ArrayList<>();
        try {
            resultSet = stmt.executeQuery(SQL_SELECT);
             groups= convertToGroup(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(GroupManagmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
    
    //convert result set to arraylist of tasks
  private  ArrayList<Group> convertToGroup(ResultSet rs) throws SQLException{
  ArrayList<Group> groups = new ArrayList<Group>();
        while(rs.next()){
             EntityFactory factory = new EntityFactory();
             
             Group group = factory.getShape(rs.getString("id"), rs.getString("name"), rs.getString("description"));
             groups.add(group);
            
         }
         rs.close();
          
    return groups; }

    @Override
    public void add_record(String group_id, String name, String description) {
        try {
            String SQL_INSERT = "INSERT INTO GROUPDB (ID, NAME, DESCRIPTION) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, group_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            int row = preparedStatement.executeUpdate();
            //affected row
            System.out.println(row);
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementDerbyJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
