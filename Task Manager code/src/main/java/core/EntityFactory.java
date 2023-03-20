/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author AMNA
 */
public class EntityFactory {
       
   public Task getShape(String id, String title, String repeat, Date date, Time time, String groupid){
      Task task  = new Task( id, title,repeat,  date,  time,  groupid);
         
      return task; }
      

   public Group getShape(String id, String name, String description){
     Group group = new Group( id,  name, description);
         
      return group; }
}
