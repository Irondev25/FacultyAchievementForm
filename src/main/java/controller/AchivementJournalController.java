/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            pst.setFloat(5, achivementJournal.getImpact_factor());
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
            sql = "update ach_journal set title_journal=?,title_paper=?,date_pub=?,type=?,impact_factor=? where pid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementJournal.getTitleJournal());
            pst.setString(2, achivementJournal.getTitlePaper());
            pst.setDate(3, achivementJournal.getDatePub());
            pst.setString(4, achivementJournal.getType());
            pst.setDouble(5, achivementJournal.getImpact_factor());
            pst.setInt(6, achivementJournal.getPid());
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
    
    public ArrayList<AchivementJournal> getAwards(int fid){
        ArrayList<AchivementJournal> awards = new ArrayList<>();
        AchivementJournal achivementJournal = new AchivementJournal();
        ResultSet resultSet;
        String sql = "";
        try{
            sql =  "select * from ach_journal where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            resultSet = pst.executeQuery();
            while(resultSet.next()){
                //journal_title paper_title date pub_date type If fid
                achivementJournal = new AchivementJournal(
                resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getString(5),
                        resultSet.getFloat(6),
                        resultSet.getInt(7)
                );
                awards.add(achivementJournal);
            }
            return awards;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return awards;
    }
}
