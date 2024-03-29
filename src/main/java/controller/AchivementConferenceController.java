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
import models.AchivementConference;

/**
 *
 * @author Keshav Chaudhary
 */
public class AchivementConferenceController extends AchivementConference{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public AchivementConferenceController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAchivementConference(AchivementConference achivementConference){
        int res=0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "insert into ach_conf(name,title,date_pre,type,fid) values(?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementConference.getConferenceName());
            pst.setString(2, achivementConference.getTitlePaper());
            pst.setDate(3, achivementConference.getDatePresentation());
            pst.setString(4, achivementConference.getType());
            pst.setInt(5, achivementConference.getFid());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int updateAchivementConference(AchivementConference achivementConference){
        int res=0;
        String sql="";
        PreparedStatement pst;
        try {
            sql = "update ach_conf set name=?,title=?,date_pre=?,type=? where pid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, achivementConference.getConferenceName());
            pst.setString(2, achivementConference.getTitlePaper());
            pst.setDate(3, achivementConference.getDatePresentation());
            pst.setString(4, achivementConference.getType());
            pst.setInt(5, achivementConference.getPid());
            res = pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementConference(int pid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_conf where pid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, pid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteAchivementConferenceFid(int fid){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "delete from ach_conf where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public ArrayList<AchivementConference> getAwards(int fid){
        ArrayList<AchivementConference> awards = new ArrayList<>();
        AchivementConference achivementConference = new AchivementConference();
        ResultSet resultSet;
        String sql = "";
        try{
            sql =  "select * from ach_conf where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            resultSet = pst.executeQuery();
            while(resultSet.next()){
                //name title date type fid
                achivementConference = new AchivementConference(resultSet.getInt(1),resultSet.getInt(6), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4),resultSet.getString(5));
                awards.add(achivementConference);
            }
            return awards;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return awards;
    }
}
