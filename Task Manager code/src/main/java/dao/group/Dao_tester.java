/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.group;

import core.Group;
import java.util.ArrayList;

/**
 *
 * @author AMNA
 */
public class Dao_tester {
    public static void main(String[] args) {
        Dao dao = new DAOMemory();
        dao.add_record("123", "Sport & health", "my daily sport group");
        dao.add_record("12", "study", "study  group");
        ArrayList<Group> groups = dao.get_all();
        for (int i = 0; i < groups.size(); i++){
            System.out.println((groups.get(i).toString()));
         }
        
        dao.delete_record("12");
        
        groups = dao.get_all();
        for (int i = 0; i < groups.size(); i++){
            System.out.println((groups.get(i).toString()));
         }
        
        
        Dao db  = new DAOImplementDerbyJDBC();
        db.add_record("3", "diet ", null);
        Group group = db.get_record("3");
        
        System.out.println(group.toString());
        
        db.delete_record("3");
        ArrayList<Group> gr = db.get_all();
        for (int i = 0; i < gr.size(); i++){
            System.out.println((gr.get(i).toString()));
         }
        
        
        
        }
    
    
    
    
        
    }
    

