/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import core.AdvancedControl;
import core.BasicControl;
import core.Group;
import core.Task;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public class Client {
    public static void main(String[] args) throws SQLException {
        BasicControl control = new BasicControl();
        
        //add task record 1
        LocalDate d = LocalDate.of(2022,Month.APRIL,10);
         LocalDate d2 = LocalDate.of(2022,Month.APRIL,14);
        Date date = Date.valueOf( d );
//         
        LocalTime t = LocalTime.of(10, 30, 10);
       Time time = Time.valueOf( t );
//        control.Create_task("1", "study Comp2101", null, date, time, null);
        
        //add task2 record 
//        LocalDate d2 = LocalDate.of(2022,Month.APRIL,13);
//        Date date2 = Date.valueOf( d2 );
//         
//        LocalTime t2 = LocalTime.of(10, 30, 10);
//        Time time2 = Time.valueOf( t2 );
//        control.Create_task("2", "study Comp2101", null, date2, time2, "1");

//control.create_group("1", "study CS ", "this grpup is for studing tasks");
//control.create_group("2", "health & sport ", null);
//control.modify_group("2", "health & sport", "This is for studing tasks :");
//control.modify_task("1", "study Comp2101", null, date, time, "111");

// ArrayList<Group> groups = control.get_all_Groups();
// for (int i = 0; i < groups.size(); i++){
//           
//            // Printing and display the elements in ArrayList
//            System.out.println(groups.get(i).toString() + " ");       
//    }
// 
// ArrayList<Task> tasks = control.get_all_tasks();
// for (int i = 0; i < tasks.size(); i++){
//           
//            // Printing and display the elements in ArrayList
//            System.out.println(tasks.get(i).toString() + " ");       
//    }
 //note that when you delete a group that contains tasks you 
 //should modify the tasks to have null in the id group
        
// ArrayList<Task> tasks = control.get_group_tasks("1");
// for (int i = 0; i < tasks.size(); i++){
//          
//          // Printing and display the elements in ArrayList
//          System.out.println(tasks.get(i).toString() + " ");       
//   }
// 
 
 AdvancedControl ad = new AdvancedControl();
 ArrayList<Task> tasks= ad.range_search(d, d2);
 for (int i = 0; i < tasks.size(); i++){
          
          // Printing and display the elements in ArrayList
          System.out.println(tasks.get(i).toString() + " ");       
   }
 
    } 
    
    
   
    
}
