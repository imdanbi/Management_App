package com.example.sd;

public class Culture {

    int studentYear;
    String courseArea;
    String courseTitle;
    String courseGrade;

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) { this.studentYear = studentYear; }

    public String getCourseArea() {
        return courseArea;
    }

    public void setCourseArea(String courseArea) {
        this.courseArea = courseArea;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }


    public Culture(int studentYear, String courseArea, String courseTitle, String courseGrade) {
        this.studentYear = studentYear;
        this.courseArea = courseArea;
        this.courseTitle = courseTitle;
        this.courseGrade = courseGrade;
    }
}
