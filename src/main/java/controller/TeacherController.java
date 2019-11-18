/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.cj.xdevapi.Result;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Teacher;

/**
 *
 * @author bhask
 */
public class TeacherController extends Teacher{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public TeacherController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public int createAccount(Teacher teacher){
        int res = 0;
        String sql = "";
        String mobSql = "";
        try{
            sql = "insert into faculty(fname,lname,minit,email,dob,doj,sex,did,loginid,password) values(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, teacher.getFname());
            pst.setString(2, teacher.getLname());
            pst.setString(3, teacher.getMname());
            pst.setString(4, teacher.getEmail());
            pst.setDate(5, teacher.getDob());
            pst.setDate(6, teacher.getDoj());
            pst.setString(7, teacher.getSex());
            pst.setInt(8, teacher.getDid());
            pst.setString(9, teacher.getLoginId());
            pst.setString(10, teacher.getPassword());
            res = pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public Teacher getTeacherByFname(String name){
        String sql = "";
        ResultSet resultSet;
        Teacher teacher = new Teacher();
        try {
          sql = "select * from faculty where fname=?";
          pst = con.prepareStatement(sql);
          pst.setString(1, name);
          resultSet = pst.executeQuery();
          if(resultSet.next()){
              teacher.setFid(resultSet.getInt(1));
              teacher.setFname(resultSet.getString(2));
              teacher.setLname(resultSet.getString(3));
              teacher.setMname(resultSet.getString(4));
              teacher.setEmail(resultSet.getString(5));
              teacher.setDob(resultSet.getDate(6));
              teacher.setDoj(resultSet.getDate(7));
              teacher.setSex(resultSet.getString(8));
              teacher.setDid(resultSet.getInt(9));
              teacher.setLoginId(resultSet.getString(10));
          }
          //new JavaMailUtil().sendMail(teacher.getEmail());
          return teacher;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public Teacher getTeacherByLoginId(String loginId){
        String sql = "";
        ResultSet resultSet;
        Teacher teacher = new Teacher();
        try {
          sql = "select * from faculty where loginid=?";
          pst = con.prepareStatement(sql);
          pst.setString(1, loginId);
          resultSet = pst.executeQuery();
          if(resultSet.next()){
              teacher.setFid(resultSet.getInt(1));
              teacher.setFname(resultSet.getString(2));
              teacher.setLname(resultSet.getString(3));
              teacher.setMname(resultSet.getString(4));
              teacher.setEmail(resultSet.getString(5));
              teacher.setDob(resultSet.getDate(6));
              teacher.setDoj(resultSet.getDate(7));
              teacher.setSex(resultSet.getString(8));
              teacher.setDid(resultSet.getInt(9));
              teacher.setLoginId(resultSet.getString(10));
              teacher.setPassword(resultSet.getString(11));
          }
          //new JavaMailUtil().sendMail(teacher.getEmail());
          return teacher;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public boolean checkLogin(Teacher teacher){
        String sql="";
        ResultSet rs = null;
        try{
            sql = "select * from faculty where loginid=? and password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1,teacher.getLoginId());
            pst.setString(2, teacher.getPassword());
            rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    public int deleteTeacher(int fid){
        int res = 0;
        String sql;
        sql = null;
        try {
            new MobileController().deleteMobile(fid);
            new AchivementAwardController().deleteAchivementAwardFid(fid);
            new AchivementConferenceController().deleteAchivementConferenceFid(fid);
            new AchivementJournalController().deleteAchivementJournalFid(fid);
            new AchivementWorkshopController().deleteAchivementWorkshopFid(fid);
            sql = "delete from faculty where fid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, fid);
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }
    
    public int updateTeacher(Teacher teacher){
        int res = 0;
        String sql = "";
        PreparedStatement pst;
        try {
            sql = "update faculty set fname=?,lname=?,minit=?,email=?,dob=?,doj=?,sex=?,did=?,loginid=?,password=? where fid=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, teacher.getFname());
            pst.setString(2, teacher.getLname());
            pst.setString(3, teacher.getMname());
            pst.setString(4, teacher.getEmail());
            pst.setDate(5, teacher.getDob());
            pst.setDate(6, teacher.getDoj());
            pst.setString(7, teacher.getSex());
            pst.setInt(8, teacher.getDid());
            pst.setString(9, teacher.getLoginId());
            pst.setString(10, teacher.getPassword());
            pst.setInt(11, teacher.getFid());
            res = pst.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.err.println("SQLError: "+e.getMessage());
        }
        return 0;
    }
}
