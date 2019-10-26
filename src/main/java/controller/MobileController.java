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
import models.Mobile;

/**
 *
 * @author bhask
 */
public class MobileController extends Mobile{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public MobileController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int setMobileNumber(Mobile mobile){
        int res = 0;
        String sql = "";
        try{
            sql = "insert into faculty_mob values(?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, mobile.getFid());
            pst.setString(2, mobile.getMobileNum());
            res = pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public int deleteMobile(int fid){
        int res;
        String sql;
        PreparedStatement pst;
        try {
            sql = "delete from faculty_mob where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteMobile(int fid, String mobileNumber){
        int res;
        String sql;
        PreparedStatement pst;
        try {
            sql = "delete from faculty_mob where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public ArrayList<String> getMobiles(int fid){
        ArrayList<String> mobileNumbersList = new ArrayList<>();
        ResultSet resultSet;
        String sql = "";
        try {
            sql = "select * from faculty_mob where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            resultSet = pst.executeQuery();
            while(resultSet.next()){
                mobileNumbersList.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return mobileNumbersList;
    }
    
    public String[] getMobileStrings(int fid){
        ArrayList<String> mobileArrayList = getMobiles(fid);
        String[] mobiles = new String[mobileArrayList.size()];
        for(int i=0; i< mobileArrayList.size(); i++){
            mobiles[i] = mobileArrayList.get(i);
        }
        return mobiles;
    }
}
