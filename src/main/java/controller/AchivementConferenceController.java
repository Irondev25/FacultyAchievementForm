/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
