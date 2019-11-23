/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author bhask
 */

public class Teacher {
    int fid;
    String fname,lname,mname,email,sex, loginId, password;
    Date dob,doj;
    int did;
    ArrayList<String> mobileList;

    public Teacher(String fname, String lname, String mname, String email, String sex, String loginId, String password, Date dob, Date doj, int did) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.email = email;
        this.sex = sex;
        this.loginId = loginId;
        this.password = password;
        this.dob = dob;
        this.doj = doj;
        this.did = did;
    }

    public Teacher() {
    }

    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public ArrayList<String> getMobileList() {
        return mobileList;
    }

    public void setMobileList(ArrayList<String> mobileList) {
        this.mobileList = mobileList;
    }
    
    public LocalDate getDobDate(){
        return this.dob.toLocalDate();
    }
    
    public LocalDate getDojDate(){
        return this.doj.toLocalDate();
    }
    
    public String getFullName(){
        return this.getFname() + " " + this.getMname() + " " +this.getLname();
    }
    
    @Override
    public String toString(){
        return getFullName();
    }
}
