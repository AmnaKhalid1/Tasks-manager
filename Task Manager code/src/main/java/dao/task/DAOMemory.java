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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMNA
 */
public class DAOMemory implements Dao {

    private ArrayList<Task> tasks = new ArrayList<>();
    
    public DAOMemory(){}
    @Override
    public void delete_record(String id) {
        for (int i = 0; i < tasks.size(); i++){
         if (tasks.get(i).getId().equals(id)){
             tasks.remove(i);
         }
        }
    }

    @Override
    public Task get_record(String id) {
         for (int i = 0; i < tasks.size(); i++){
         if (tasks.get(i).getId().equals(id)){
             return tasks.get(i);
         }
        }
    return null ;}

    @Override
    public ArrayList<Task> get_all() {
            return tasks;    }

    @Override
    public void add_record(String taskid,String title ,String repeat, Date date,Time time, String groupid) {
        Task task = new Task( taskid, title , repeat,  date, time,  groupid);
        tasks.add(task);
    }
    
}
