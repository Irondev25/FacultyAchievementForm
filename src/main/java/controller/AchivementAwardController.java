/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.AchievementAward;

/**
 *
 * @author Keshav Chaudhary
 */
public class AchivementAwardController extends AchievementAward{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public AchivementAwardController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAchivementAward(AchievementAward achievementAward){
        int res=0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "insert into ach_award(ondate,details,fid) values(?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, achievementAward.getFid());
            pst.setDate(2, achievementAward.getDate());
            pst.setString(3, achievementAward.getDetailAward());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int updateAchivementAward(AchievementAward achievementAward){
        int res=0;
        String sql="";
        PreparedStatement pst;
        try {
            sql = "update ach_award set ondate=?,details=?";
            pst = con.prepareStatement(sql);
            pst.setDate(1, achievementAward.getDate());
            pst.setString(2,achievementAward.getDetailAward());
            res = pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementAward(int pid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_award where pid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, pid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementAwardFid(int fid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_award where fid=?";
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
