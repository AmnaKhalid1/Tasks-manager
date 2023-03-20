/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import database.DatabaseManagment;
import database.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMNA
 */
public  class BasicControl {
    GroupManagmentDB mannageGroup = new GroupManagmentDB() ;
    TaskManagmentDB mannagetask = new TaskManagmentDB() ;
    
    public void Create_task(String taskid,String title ,String repeat, Date date,Time time, String groupid ) throws SQLException{
        mannagetask.add_record(taskid, title ,repeat, date,time, groupid );
    }
    
    public void create_group(String group_id,String name ,String description) throws SQLException{
        mannageGroup.add_record(group_id, name , description);
    
    }
    
     public void delete_group(String id) {
        mannageGroup.delete_record(id);
        
    }

    public ResultSet get_group_record(String id) {
        ResultSet rs = mannageGroup.get_record(id);
    
        return rs;}
    
    public void modify_group(String group_id,String name ,String description) throws SQLException{
        mannageGroup.modify_record(group_id, name, description);
    
    }
    
    
    public ArrayList<Group> get_all_Groups() throws SQLException{
        ResultSet rs = mannageGroup.get_all();
        ArrayList<Group> groups = convertToGroup(rs);
    return groups;}
    
    
    public ResultSet get_today_tasks (LocalDate date ){
        ResultSet rs = mannagetask.range_search(date, date);
    return rs ;}
    
    public void delete_task(String id) {
        mannagetask.delete_record(id);
    }
    
    public ResultSet get_task(String id){
        ResultSet rs = mannagetask.get_record(id);
    return rs;}
    
    public ArrayList<Task> get_all_tasks() throws SQLException{
        
        ResultSet rs = mannagetask.get_all();
        ArrayList<Task> tasks= convertToTask(rs);
    return tasks;
    }
  public void  modify_task(String id ,String title,String repeat ,Date date,Time time, String groupid ) throws SQLException{
      mannagetask.modify_record(id, title, repeat, date, time, groupid);
  
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
  
  //convert result set to arraylist of tasks
  public ArrayList<Group> convertToGroup(ResultSet rs) throws SQLException{
  ArrayList<Group> groups = new ArrayList<Group>();
        while(rs.next()){
             EntityFactory factory = new EntityFactory();
             
             Group group = factory.getShape(rs.getString("id"), rs.getString("name"), rs.getString("description"));
             groups.add(group);
            
         }
         rs.close();
          
    return groups; }
  
  public ArrayList<Task> get_group_tasks(String group_id) throws SQLException{
      ArrayList<Task> tasks = get_all_tasks();
      ArrayList<Task> group_tasks = new ArrayList<Task> () ;
      for (int i = 0; i < tasks.size(); i++){
           
        if (tasks.get(i).getGroupid().equals(group_id)){
            group_tasks.add(tasks.get(i));
        }          
    }
  return group_tasks;}
}
