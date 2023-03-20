/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database;

import java.sql.ResultSet;

/**
 *
 * @author AMNA
 */
public interface DatabaseManagment {
    public void connect ();
    public void delete_record(String id);
    public ResultSet get_record(String id);
    public ResultSet get_all();
    
    
    
}
