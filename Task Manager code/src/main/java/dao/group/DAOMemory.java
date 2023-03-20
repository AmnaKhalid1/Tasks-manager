/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.group;

import core.Group;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMNA
 */
public class DAOMemory implements Dao {

    private ArrayList<Group> groups = new ArrayList<>();
    
    public DAOMemory(){}
    @Override
    public void delete_record(String id) {
        for (int i = 0; i < groups.size(); i++){
         if (groups.get(i).getId().equals(id)){
             groups.remove(i);
         }
        }
    }

    @Override
    public Group get_record(String id) {
         for (int i = 0; i < groups.size(); i++){
         if (groups.get(i).getId().equals(id)){
             return groups.get(i);
         }
        }
    return null ;}

    @Override
    public ArrayList<Group> get_all() {
            return groups;    }

    @Override
    public void add_record(String group_id, String name, String description) {
        Group group = new Group(group_id,  name, description);
        groups.add(group);
    }
    
}
