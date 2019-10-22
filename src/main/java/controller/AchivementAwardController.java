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
import java.sql.SQLDataException;
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
            sql = "insert into ach_award values(?,?,?)";
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
    
    public int deleteAchivementAward(int fid,Date date){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_award where fid=? and ondate=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            pst.setDate(2, date);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
}
