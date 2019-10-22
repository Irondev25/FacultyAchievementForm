/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
