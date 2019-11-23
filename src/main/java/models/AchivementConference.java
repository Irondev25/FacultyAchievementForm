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
public class AchivementConference {
    int pid;
    int fid;
    String conferenceName;
    String titlePaper;
    Date datePresentation;
    String type;

    
    public AchivementConference() {
    }
    
    public AchivementConference(int pid,int fid, String conferenceName, String titlePaper, Date datePresentation, String type) {
        this.pid = pid;
        this.fid = fid;
        this.conferenceName = conferenceName;
        this.titlePaper = titlePaper;
        this.datePresentation = datePresentation;
        this.type = type;
    }
    
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getTitlePaper() {
        return titlePaper;
    }

    public void setTitlePaper(String titlePaper) {
        this.titlePaper = titlePaper;
    }

    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public LocalDate getLocalDate(){
        return this.datePresentation.toLocalDate();
    }
    
    public String toString(){
        String output = "<html><hr/>Conference Name: <b>" + 
                getConferenceName().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + 
                "</b><br/>Paper Title: " + 
                getTitlePaper().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + 
                "<br/>Presentation Date: " + getDatePresentation().toString() + "<br/>Type: "+ getType() + "<hr/></html>";
        return output;
    }
    
}
