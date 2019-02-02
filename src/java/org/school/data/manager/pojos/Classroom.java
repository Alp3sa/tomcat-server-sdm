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
public class Classroom {
    int ID;
    String classroomName;
    //String subject;
    String details;
    String image;

    public Classroom() {
    }

    public Classroom(String classroomName,String details,String image) {
        this.classroomName = classroomName;
        //this.subject = subject;
        this.details = details;
        this.image = image;
    }

    public Classroom(int ID, String classroomName, String details,String image) {
        this.ID=ID;
        this.classroomName = classroomName;
        //this.subject = subject;
        this.details = details;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(final String classroomName) {
        this.classroomName = classroomName;
    }

    /*public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }*/

    public int getID() {
        return ID;
    }

    public void setID(final int ID) {
        this.ID = ID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}