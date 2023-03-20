/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public class test {
    public static void main(String[] args) throws SQLException {
        AdvancedControl b = new AdvancedControl() ;
        
        LocalDate d = LocalDate.of(2010,Month.JULY,2);
        LocalDate d2 = LocalDate.of(2010,Month.JULY,25);
        ArrayList<Task> tasks = b.range_search(d, d2);
        Task t1 =tasks.get(0);
        System.out.println("task : "+t1.getId());
        Task t2 =tasks.get(1);
        System.out.println("task : "+t2.getId());
    }
}
