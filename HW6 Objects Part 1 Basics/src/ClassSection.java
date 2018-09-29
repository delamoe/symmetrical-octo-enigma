/*
     * Class	:	ClassSection.java
     *
     * Purpose 	:	HW6 Objects Part 1 Basics
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	9/25/2018
     */

public class ClassSection {
    int CRN;
    String dept;
    int courseNumber;
    String instructionalMode;
    String meetingDays;
    String meetingTimes;
    int capacity;
    int enrollment;
    int instructorsID;

    ClassSection() {
        CRN = 0;
        dept = "";
        courseNumber = 0;
        instructionalMode = "";
        meetingDays = "";
        meetingTimes = "";
        capacity = 0;
        enrollment = 0;
        instructorsID = 0;
    }

    void setCRN(int newCRN) {
        CRN = newCRN;
    }

    void setDept(String newDept) {
        dept = newDept;
    }

    void setCourseNumber(int newCourseNumber) {
        courseNumber = newCourseNumber;
    }

    void setInstructionalMode(String newInstructionalMode) {
        instructionalMode = newInstructionalMode;
    }

    void setMeetingDays(String newMeetingDays) {
        meetingDays = newMeetingDays;
    }

    void setMeetingTimes(String newMeetingTimes) {
        meetingTimes = newMeetingTimes;
    }

    void setCapacity(int newCapacity) {
        capacity = newCapacity;
    }

    void setEnrollment(int newEnrollment) {
        enrollment = newEnrollment;
    }

    void setInstructorsID(int newInstructorsID) {
        instructorsID = newInstructorsID;
    }

    int getCRN() {
        return CRN;
    }

    String getDept() {
        return dept;
    }

    int getCourseNumber() {
        return courseNumber;
    }

    String getInstructionalMode() {
        return instructionalMode;
    }

    String getMeetingDays() {
        return meetingDays;
    }

    String getMeetingTimes() {
        return meetingTimes;
    }

    int getCapacity() {
        return capacity;
    }

    int getEnrollment() {
        return enrollment;
    }

    int getInstructorsID() {
        return instructorsID;
    }

    public String toString() {
        String printString = "";
        printString +=
            "\nCRN                 : "  + getCRN()  +
            "\nDepartment          : "  + getDept()  +
            "\nCourse number       : "  + getCourseNumber()  +
            "\nInstructional mode  : "  + getInstructionalMode()  +
            "\nMeeting days        : "  + getMeetingDays()  +
            "\nMeeting times       : "  + getMeetingTimes()  +
            "\nCapacity            : "  + getCapacity()  +
            "\nEnrollment          : "  + getEnrollment()  +
            "\nInstructor’s ID     : "  + getInstructorsID();
        return printString;
    }

}