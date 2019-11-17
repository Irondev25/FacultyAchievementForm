/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AchivementAwardController;
import controller.AchivementConferenceController;
import controller.AchivementJournalController;
import controller.AchivementWorkshopController;
import controller.TeacherController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import models.AchievementAward;
import models.AchivementConference;
import models.AchivementJournal;
import models.AchivementWorkshop;
import models.Teacher;

/**
 *
 * @author bhask
 */
public class FacultyPanel extends javax.swing.JFrame {

    /**
     * Creates new form FacultyPanel
     */
    public FacultyPanel(Teacher teacher) {
        this.teacher = teacher;
        awards = new AchivementAwardController().getAwards(this.teacher.getFid());
        conferences = new AchivementConferenceController().getAwards(this.teacher.getFid());
        journals = new AchivementJournalController().getAwards(this.teacher.getFid());
        workshops = new AchivementWorkshopController().getAwards(this.teacher.getFid());
        initComponents();
    }
        
    private String[] getAwardString(ArrayList<AchievementAward> list){
        int n = list.size();
        String[] strings = new String[n];
        for(int i=0; i<n; i++){
            strings[i] = list.get(i).toString();
        }
        return strings;
    }
    
    private String[] getConfString(ArrayList<AchivementConference> list){
        int n = list.size();
        String[] strings = new String[n];
        for(int i=0; i<n; i++){
            strings[i] = list.get(i).toString();
        }
        return strings;
    }
    
    private String[] getJournalString(ArrayList<AchivementJournal> list){
        int n = list.size();
        String[] strings = new String[n];
        for(int i=0; i<n; i++){
            strings[i] = list.get(i).toString();
        }
        return strings;
    }
    
    private String[] getWorkshopString(ArrayList<AchivementWorkshop> list){
        int n = list.size();
        String[] strings = new String[n];
        for(int i=0; i<n; i++){
            strings[i] = list.get(i).toString();
        }
        return strings;
    }
    
    
    public void refreshAward(){
        awards = new AchivementAwardController().getAwards(this.teacher.getFid());
        AwardList.setModel(new javax.swing.AbstractListModel<String>() {
            //AchivementAwardController achivementAwardController = new AchivementAwardController();
            //awards = achivementAwardController.getAwards(teacher.getFid());
            String[] strings = getAwardString(awards);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(AwardList);
    }
    
    public void refreshConf(){
        conferences = new AchivementConferenceController().getAwards(this.teacher.getFid());
        confList.setModel(new javax.swing.AbstractListModel<String>() {
            //AchivementConferenceController achivementConferenceController = new AchivementConferenceController();
            //conferences = achivementConferenceController.getAwards(this.teacher.getFid());
            String[] strings = getConfString(conferences);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(confList);
    }
    
    public void refreshJournal(){
        this.journals = new AchivementJournalController().getAwards(this.teacher.getFid());
        journalList.setModel(new javax.swing.AbstractListModel<String>() {
            //journals = new AchivementJournalController().getAwards(teacher.getFid());
            String[] strings = getJournalString(journals);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(journalList);
    }
    
    public void refreshWorkshop(){
        workshops = new AchivementWorkshopController().getAwards(teacher.getFid());
        workshopList.setModel(new javax.swing.AbstractListModel<String>() {
            //workshops = new AchivementWorkshopController().getAwards(teacher.getFid());
            String[] strings = getWorkshopString(workshops);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(workshopList);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AwardList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        confList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        journalList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        workshopList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        editMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        LogoutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        awardMenuItem = new javax.swing.JMenuItem();
        conferenceMenuItem = new javax.swing.JMenuItem();
        journalMenuItem = new javax.swing.JMenuItem();
        workshopMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AwardList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = getAwardString(awards);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        AwardList.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    AwardList.setSelectedIndex(AwardList.locationToIndex(e.getPoint()));
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemShow = new JMenuItem("Show");
                    itemShow.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            new ShowAward(teacher, awards.get(AwardList.getSelectedIndex())).setVisible(true);
                        }
                    });
                    JMenuItem itemUpdate = new JMenuItem("Update");
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            AchievementAward temp = awards.get(AwardList.getSelectedIndex());
                            System.out.println(temp.getPid());
                            int res = new AchivementAwardController().deleteAchivementAward(temp.getPid());
                            if(res > 0){
                                JOptionPane.showMessageDialog(null, "Award Deleted");
                                refreshAward();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Unsuccessful");
                            }
                        }
                    });
                    menu.add(itemShow);
                    menu.add(itemRemove);
                    menu.add(itemUpdate);
                    menu.show(AwardList, e.getPoint().y, e.getPoint().y);
                }
            }
        });
        jScrollPane1.setViewportView(AwardList);

        jTabbedPane1.addTab("Awards", jScrollPane1);

        confList.setModel(new javax.swing.AbstractListModel<String>() {
            //conferences = new AchivementConferenceController().getAwards(teacher.getFid());
            String[] strings = getConfString(conferences);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        confList.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    confList.setSelectedIndex(confList.locationToIndex(e.getPoint()));
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemShow = new JMenuItem("Show");
                    itemShow.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            new ShowConference(teacher,conferences.get(confList.getSelectedIndex())).setVisible(true);
                        }
                    });
                    JMenuItem itemUpdate = new JMenuItem("Update");
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            AchivementConference temp = conferences.get(confList.getSelectedIndex());
                            int res = new AchivementConferenceController().deleteAchivementConference(temp.getPid());
                            if(res > 0){
                                JOptionPane.showMessageDialog(null, "Award Deleted");
                                refreshConf();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Unsuccessful");
                            }
                        }
                    });
                    menu.add(itemShow);
                    menu.add(itemRemove);
                    menu.add(itemUpdate);
                    menu.show(confList, e.getPoint().y, e.getPoint().y);
                }
            }
        });
        jScrollPane2.setViewportView(confList);

        jTabbedPane1.addTab("Conference", jScrollPane2);

        journalList.setModel(new javax.swing.AbstractListModel<String>() {
            //ArrayList<AchivementJournal> journals = new AchivementJournalController().getAwards(teacher.getFid());
            String[] strings = getJournalString(journals);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        journalList.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    journalList.setSelectedIndex(journalList.locationToIndex(e.getPoint()));
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemShow = new JMenuItem("Show");
                    itemShow.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            new ShowJournal(teacher, journals.get(journalList.getSelectedIndex())).setVisible(true);
                        }
                    });
                    JMenuItem itemUpdate = new JMenuItem("Update");
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            AchivementJournal temp = journals.get(journalList.getSelectedIndex());

                            int res = new AchivementJournalController().deleteAchivementJournal(temp.getPid());
                            if(res > 0){
                                JOptionPane.showMessageDialog(null, "Award Deleted");
                                refreshJournal();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Unsuccessful");
                            }
                        }
                    });
                    menu.add(itemShow);
                    menu.add(itemRemove);
                    menu.add(itemUpdate);
                    menu.show(journalList, e.getPoint().y, e.getPoint().y);
                }
            }
        });
        jScrollPane3.setViewportView(journalList);

        jTabbedPane1.addTab("Journal", jScrollPane3);

        workshopList.setModel(new javax.swing.AbstractListModel<String>() {
            //ArrayList<AchivementWorkshop> workshops = new AchivementWorkshopController().getAwards(teacher.getFid());
            String[] strings = getWorkshopString(workshops);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        workshopList.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    workshopList.setSelectedIndex(workshopList.locationToIndex(e.getPoint()));
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemShow = new JMenuItem("Show");
                    itemShow.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            new ShowWorkShop(teacher, workshops.get(workshopList.getSelectedIndex())).setVisible(true);
                        }
                    });
                    JMenuItem itemUpdate = new JMenuItem("Update");
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            AchivementWorkshop temp = workshops.get(workshopList.getSelectedIndex());
                            int res = new AchivementWorkshopController().deleteAchivementWorkshop(temp.getPid());
                            if(res > 0){
                                JOptionPane.showMessageDialog(null, "Award Deleted");
                                refreshWorkshop();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Unsuccessful");
                            }
                        }
                    });
                    menu.add(itemShow);
                    menu.add(itemRemove);
                    menu.add(itemUpdate);
                    menu.show(workshopList, e.getPoint().y, e.getPoint().y);
                }
            }
        });
        jScrollPane4.setViewportView(workshopList);

        jTabbedPane1.addTab("Workshop", jScrollPane4);

        jMenu2.setText("Welcome " + this.teacher.getFname());

        editMenuItem.setText("Edit Profile");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(editMenuItem);

        deleteMenuItem.setText("Delete Profile");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(deleteMenuItem);

        LogoutMenuItem.setText("Logout");
        LogoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(LogoutMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Create Achivement");

        awardMenuItem.setText("Award");
        awardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                awardMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(awardMenuItem);

        conferenceMenuItem.setText("Conference");
        conferenceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conferenceMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(conferenceMenuItem);

        journalMenuItem.setText("Journal");
        journalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journalMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(journalMenuItem);

        workshopMenuItem.setText("Workshop");
        workshopMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workshopMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(workshopMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        // TODO add your handling code here:
        updateFaculty upFaculty = new updateFaculty(teacher);
        upFaculty.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void LogoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuItemActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your profile?", "Delete Profile",  JOptionPane.YES_NO_OPTION);
        if(input == 0){
            TeacherController teacherController = new TeacherController();
            int res = teacherController.deleteTeacher(this.teacher.getFid());
            if(res >= 1){
                JOptionPane.showMessageDialog(this, "teacher is successfully deleted");
                this.dispose();
                new Login().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Problem occured when deleting teacher");
            }
        }
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void awardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_awardMenuItemActionPerformed
        // TODO add your handling code here:
        Award award = new Award(this.teacher, this);
        award.setVisible(true);
    }//GEN-LAST:event_awardMenuItemActionPerformed

    private void conferenceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conferenceMenuItemActionPerformed
        // TODO add your handling code here:
        Conference conference = new Conference(this.teacher, this);
        conference.setVisible(true);
    }//GEN-LAST:event_conferenceMenuItemActionPerformed

    private void journalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalMenuItemActionPerformed
        // TODO add your handling code here:
        new Journal(this.teacher,this).setVisible(true);
    }//GEN-LAST:event_journalMenuItemActionPerformed

    private void workshopMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workshopMenuItemActionPerformed
        // TODO add your handling code here:
        new Workshop(this.teacher,this).setVisible(true);
    }//GEN-LAST:event_workshopMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacultyPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyPanel(new Teacher()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AwardList;
    private javax.swing.JMenuItem LogoutMenuItem;
    private javax.swing.JMenuItem awardMenuItem;
    private javax.swing.JList<String> confList;
    private javax.swing.JMenuItem conferenceMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> journalList;
    private javax.swing.JMenuItem journalMenuItem;
    private javax.swing.JList<String> workshopList;
    private javax.swing.JMenuItem workshopMenuItem;
    // End of variables declaration//GEN-END:variables
    
    //custom variables
    public Teacher teacher;
    public ArrayList<AchievementAward> awards;
    public ArrayList<AchivementConference> conferences;
    public ArrayList<AchivementJournal> journals;
    public ArrayList<AchivementWorkshop> workshops;
}

      

