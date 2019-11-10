/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author bhask
 */
public class AchivementWorkshop {
    int pid;
    String topic;
    Date date_workshop;
    String location;
    String type;
    int fid;

    public AchivementWorkshop(int pid, String topic, Date date_workshop, String location, String type, int fid) {
        this.pid = pid;
        this.topic = topic;
        this.date_workshop = date_workshop;
        this.location = location;
        this.type = type;
        this.fid = fid;
    }

    public AchivementWorkshop() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate_workshop() {
        return date_workshop;
    }

    public void setDate_workshop(Date date_workshop) {
        this.date_workshop = date_workshop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
    
    public String toString(){
        return topic+" on "+date_workshop.toString();
    }
}
