/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import database.GroupManagmentDB;
import database.TaskManagmentDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMNA
 */
public class AdvancedControl extends BasicControl {
    
    public AdvancedControl (){
    
      GroupManagmentDB mannageGroup = super.mannageGroup;
      TaskManagmentDB mannagetask  = super.mannagetask ;
    }
    
    public ArrayList<Task> range_search (LocalDate start ,LocalDate end) throws SQLException{
        
        ResultSet rs = mannagetask.range_search(start, end);
        ArrayList<Task> tasks = new ArrayList<Task>();
        while(rs.next()){
             EntityFactory factory = new EntityFactory();
             
             Task task = factory.getShape(rs.getString("taskid"), rs.getString("TITLE"), rs.getString("taskrepeat"), rs.getDate("taskdate"), rs.getTime("tasktime"), rs.getString("groupid"));
             tasks.add(task);
            
         }
         rs.close();
          
    return tasks;}

    
}
