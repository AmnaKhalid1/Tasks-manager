/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

/*
1- should add handler when user try to insert an entity with the same id .
2- if an id does not exist theuser shpuld be notified .
3- Testing use cases are not done 
4- DOA is not implemented .
5- the responsible for not causing the errors is th program mangament since user can not decide the id 

*/



/**
 *
 * @author AMNA
 */
public class Call {
    
    public static void main(String[] args) throws SQLException{
        /*
        
         GroupManagmentDB dt = new GroupManagmentDB();
        dt.connect();       
        dt.add_record(14,"school home works ", "This group is for school homeworks includeing kkkkdk");
        dt.modify_record(14, "school home works ", "home works are important ");
        dt.delete_record(11);
        ResultSet rs = dt.get_record(11);
          while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("ID"));
            System.out.print(", Name: " + rs.getString("NAME"));
            System.out.print(", Description : " + rs.getString("DESCRIPTION"));
            
         }
         rs.close();
        
        */
       TaskManagmentDB dt_task = new TaskManagmentDB();
       LocalDate d = LocalDate.of(2010,Month.JULY,2);
       Date date = Date.valueOf( d );
       
       LocalTime t = LocalTime.of(10, 30, 10);
       Time time = Time.valueOf( t );

       
       
       System.out.println(d);
       System.out.println(t);
       //dt_task.add_record("1", "helth and food", null, date,time,null);
       //dt_task.add_record("2", " sport", "w", date,time,null);
       ResultSet rs = dt_task.get_all();
          while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getString("taskID"));
            System.out.print("  Title:  " + rs.getString("TITLE"));
            
         }
         rs.close();
         //dt_task.delete_record("0");
         //dt_task.modify_record("0", "finally worked ","W",date,time,null);
         System.out.println("between 12 and 10 ");
         ResultSet rss = dt_task.range_search(d, d);
           
          while(rss.next()){
            //Display values
            System.out.print("ID: " + rss.getString("taskID"));
            System.out.print("  Title:  " + rss.getString("TITLE"));
            
         }
         rss.close();
         
         
}

}
