/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.group;

import core.Group;
import core.Task;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public interface Dao {
    public void add_record(String group_id,String name ,String description);
    public void delete_record(String id);
    public Group get_record(String id);
    public ArrayList<Group> get_all();
}
