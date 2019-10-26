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
import models.AchivementWorkshop;

/**
 *
 * @author bhask
 */
public class AchivementWorkshopController {
    Database db;
    Connection con;
    PreparedStatement pst;

    public AchivementWorkshopController() {
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAchivementWorkshop(AchivementWorkshop achivementWorkshop){
        String sql="";
        int res=0;
        try {
            sql = "insert into ach_workshop(topic,date_workshop,location,type,fid) values(?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementWorkshop.getTopic());
            pst.setDate(2, achivementWorkshop.getDate_workshop());
            pst.setString(3, achivementWorkshop.getLocation());
            pst.setString(4, achivementWorkshop.getType());
            pst.setInt(5, achivementWorkshop.getFid());
            res=pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int updateAchivementWorkshop(AchivementWorkshop achivementWorkshop){
        String sqlString="";
        int res=0;
        try {
            sqlString="update ach_workshop(topic,date_workshop,location,type) values(?,?,?,?)";
            pst = con.prepareStatement(sqlString);
            pst.setString(1, achivementWorkshop.getTopic());
            pst.setDate(2, achivementWorkshop.getDate_workshop());
            pst.setString(3, achivementWorkshop.getLocation());
            pst.setString(4, achivementWorkshop.getType());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementWorkshop(int pid){
        int res = 0;
        String sql;
        try {
            sql = "delete from ach_workshop where pid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, pid);
            res = pst.executeUpdate();
            return res;
        } catch (Exception e) {
        }
        return res;
    }
    
    public int deleteAchivementWorkshopFid(int fid){
        int res = 0;
        String sql;
        try {
            sql = "delete from ach_workshop where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (Exception e) {
        }
        return res;
    }
}
