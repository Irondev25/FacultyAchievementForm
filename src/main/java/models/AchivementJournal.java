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
public class AchivementJournal {
    int fid;
    String titleJournal;
    String titlePaper;
    Date datePub;
    String type;

    public AchivementJournal(int fid, String titleJournal, String titlePaper, Date datePub, String type) {
        this.fid = fid;
        this.titleJournal = titleJournal;
        this.titlePaper = titlePaper;
        this.datePub = datePub;
        this.type = type;
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
    
}
