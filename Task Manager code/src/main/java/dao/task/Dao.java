/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.task;

import dao.group.*;
import core.Group;
import core.Task;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public interface Dao {
    public void add_record(String taskid,String title ,String repeat, Date date,Time time, String groupid);
    public void delete_record(String id);
    public Task get_record(String id);
    public ArrayList<Task> get_all();
}
