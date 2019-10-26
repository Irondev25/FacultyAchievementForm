/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.AchievementAward;
import models.AchivementJournal;

/**
 *
 * @author Keshav Chaudhary
 */
public class AchivementJournalController extends AchivementJournal{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public AchivementJournalController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAchivementJournal(AchivementJournal achivementJournal){
        int res=0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "insert into ach_journal(title_journal,title_paper,date_pub,type,impact_factor,fid) values(?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementJournal.getTitleJournal());
            pst.setString(2, achivementJournal.getTitlePaper());
            pst.setDate(3, achivementJournal.getDatePub());
            pst.setString(4, achivementJournal.getType());
            pst.setDouble(5, achivementJournal.getImpact_factor());
            pst.setInt(6, achivementJournal.getFid());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int updateAchivementJournal(AchivementJournal achivementJournal){
        int res=0;
        String sql="";
        PreparedStatement pst;
        try {
            sql = "update ach_journal set title_journal=?,title_paper=?,date_pub=?,type=?,impact_factor=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementJournal.getTitleJournal());
            pst.setString(2, achivementJournal.getTitlePaper());
            pst.setDate(3, achivementJournal.getDatePub());
            pst.setString(4, achivementJournal.getType());
            pst.setDouble(5, achivementJournal.getImpact_factor());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementJournal(int pid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_journal where pid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, pid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementJournalFid(int fid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_journal where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
