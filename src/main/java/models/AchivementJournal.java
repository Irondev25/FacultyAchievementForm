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
public class AchivementJournal {
    int pid;
    String titleJournal;
    String titlePaper;
    Date datePub;
    String type;
    float impact_factor;
    int fid;

    public AchivementJournal(int pid, String titleJournal, String titlePaper, Date datePub, String type, float impact_factor, int fid) {
        this.pid = pid;
        this.titleJournal = titleJournal;
        this.titlePaper = titlePaper;
        this.datePub = datePub;
        this.type = type;
        this.impact_factor = impact_factor;
        this.fid = fid;
    }
    
    
    public AchivementJournal() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getTitleJournal() {
        return titleJournal;
    }

    public void setTitleJournal(String titleJournal) {
        this.titleJournal = titleJournal;
    }

    public String getTitlePaper() {
        return titlePaper;
    }

    public void setTitlePaper(String titlePaper) {
        this.titlePaper = titlePaper;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public float getImpact_factor() {
        return impact_factor;
    }

    public void setImpact_factor(float impact_factor) {
        this.impact_factor = impact_factor;
    }
    
    public LocalDate getLocalDate(){
        return this.datePub.toLocalDate();
    }
    
    public String toString(){
        return titleJournal+":"+titlePaper+" on "+datePub.toString();
    }
}
