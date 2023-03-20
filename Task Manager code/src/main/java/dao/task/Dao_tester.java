/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.task;

import dao.group.*;
import core.Group;
import core.Task;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public class Dao_tester {
    public static void main(String[] args) {
        Dao dao = new DAOImplementDerbyJDBC();
       LocalDate d = LocalDate.of(2010,Month.JULY,2);
       Date date = Date.valueOf( d );
       
       LocalTime t = LocalTime.of(10, 30, 10);
       Time time = Time.valueOf( t );

       
       
       System.out.println(d);
       System.out.println(t);
       dao.add_record("1", "helth and food", null, date,time,null);
       dao.add_record("2", " sport", "w", date,time,null);
       ArrayList<Task> tasks = dao.get_all();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).toString());
            
        }
       
        
        
        }
    
    
    
    
        
    }
    

