/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_pkg;

import java.io.Serializable;

/**
 *
 * @author Mustaqueem Alam
 */
public class Course  implements Serializable{
        private String courseId;
    private String courseTitle;
    private int noOfCredits;
    private String selectedPO;
    private String selectedCO;
    private String selectedPreReq;
    private String courseCategory;
    private String courseType;
    private String descriptionOfCO;

    public Course(String courseId, String courseTitle, int noOfCredits, String selectedPO, String selectedCO,
                  String selectedPreReq, String courseCategory, String courseType, String descriptionOfCO) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.noOfCredits = noOfCredits;
        this.selectedPO = selectedPO;
        this.selectedCO = selectedCO;
        this.selectedPreReq = selectedPreReq;
        this.courseCategory = courseCategory;
        this.courseType = courseType;
        this.descriptionOfCO = descriptionOfCO;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(int noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public String getSelectedPO() {
        return selectedPO;
    }

    public void setSelectedPO(String selectedPO) {
        this.selectedPO = selectedPO;
    }

    public String getSelectedCO() {
        return selectedCO;
    }

    public void setSelectedCO(String selectedCO) {
        this.selectedCO = selectedCO;
    }

    public String getSelectedPreReq() {
        return selectedPreReq;
    }

    public void setSelectedPreReq(String selectedPreReq) {
        this.selectedPreReq = selectedPreReq;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDescriptionOfCO() {
        return descriptionOfCO;
    }

    public void setDescriptionOfCO(String descriptionOfCO) {
        this.descriptionOfCO = descriptionOfCO;
    }
    
}
