/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author AMNA
 */
public class Task implements Entity{
   
    public Task(String id, String title, String repeat, Date date, Time time, String groupid) {
        this.id = id;
        this.title = title;
        this.repeat = repeat;
        this.date = date;
        this.time = time;
        this.groupid = groupid;
    }
    
    public void set_all_task(String id, String title, String repeat, Date date, Time time, String groupid){
    
        this.id = id;
        this.title = title;
        this.repeat = repeat;
        this.date = date;
        this.time = time;
        this.groupid = groupid;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    private String id ;
    private String title ;
    private String repeat ;
    private Date date;
    private Time time ;
    private String groupid;

    

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRepeat() {
        return repeat;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getGroupid() {
        return groupid;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title=" + title + ", repeat=" + repeat + ", date=" + date + ", time=" + time + ", groupid=" + groupid + '}';
    }

     
}
