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
import java.util.ArrayList;
import models.Department;

/**
 *
 * @author bhask
 */
public class DepartmentController extends Department{
    Database db;
    PreparedStatement pst;
    Connection con;
    
    public DepartmentController(){
        super();
        db = new Database();
        con = db.getConnection();
    }
    
    public ArrayList<Department> getDepartmentList(){
        int res=0;
        String sql = "";
        ResultSet resultSet;
        ArrayList<Department> departments = new ArrayList<Department>();
        int did,hodid;
        String name;
        try{
            sql = "select * from department";
            pst = con.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while(resultSet.next()){
                did = resultSet.getInt(1);
                name = resultSet.getString(2);
                hodid = resultSet.getInt(3);
                departments.add(new Department(did,name,hodid));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return departments;
    }
    
}
