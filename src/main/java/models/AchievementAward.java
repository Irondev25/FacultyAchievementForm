/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author bhask
 */
public class AchievementAward {
    int pid;
    int fid;
    Date date;
    String detailAward;

    public AchievementAward() {
    }
    
    public AchievementAward(int pid, int fid, Date date, String detailAward) {
        this.pid = pid;
        this.fid = fid;
        this.date = date;
        this.detailAward = detailAward;
    }
    
    public int getPid() {
        return pid;
    }
    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetailAward() {
        return detailAward;
    }

    public void setDetailAward(String detailAward) {
        this.detailAward = detailAward;
    }
    
    public LocalDate getLocalDate(){
        return this.date.toLocalDate();
    }
    
    @Override
    public String toString(){
        String detail =  getDetailAward();
        String output = "<html><hr/>Details: " + 
                detailAward.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "<br/>" + 
                "Date: " + date.toString()+"<hr/></html";
        return output;
    }
}
