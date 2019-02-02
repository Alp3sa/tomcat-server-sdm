/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.data.manager.pojos;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class Enrollment {
    int ID;
    int userID;
    int subjectID;

    public Enrollment() {
    }
    
    public Enrollment(int ID, int userID, int subjectID) {
        this.userID = userID;
        this.subjectID = subjectID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }
}
