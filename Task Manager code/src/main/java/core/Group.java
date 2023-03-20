/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author AMNA
 */
public class Group implements Entity {
    private String id ;
    private String  name ;
    private String description;

    Group(){}
    public Group(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public void set_all_group(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
    
    
    
    
}
