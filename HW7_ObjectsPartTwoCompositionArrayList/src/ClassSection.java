/*
     * Class	:	ClassSection.java
     *
     * Purpose 	:	HW6 Objects Part 1 Basics
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
     */
    
import java.util.List;
import java.util.ArrayList;

public class ClassSection {
    private int CRN;
    private String dept;
    private int courseNumber;
    private String instructionalMode;
    private String meetingDays;
    private String meetingTimes;
    private int capacity;
    private int enrollment;
    private int instructorsID;
    private List <Student> studentList = new ArrayList <Student> ();

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

    public void setCRN(int newCRN) {
        CRN = newCRN;
    }

    public void setDept(String newDept) {
        dept = newDept;
    }

    public void setCourseNumber(int newCourseNumber) {
        courseNumber = newCourseNumber;
    }

    public void setInstructionalMode(String newInstructionalMode) {
        instructionalMode = newInstructionalMode;
    }

    public void setMeetingDays(String newMeetingDays) {
        meetingDays = newMeetingDays;
    }

    public void setMeetingTimes(String newMeetingTimes) {
        meetingTimes = newMeetingTimes;
    }

    public void setCapacity(int newCapacity) {
        capacity = newCapacity;
    }

    public void setEnrollment(int newEnrollment) {
        enrollment = newEnrollment;
    }

    public void setInstructorsID(int newInstructorsID) {
        instructorsID = newInstructorsID;
    }

    public int getCRN() {
        return CRN;
    }

    public String getDept() {
        return dept;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getInstructionalMode() {
        return instructionalMode;
    }

    public String getMeetingDays() {
        return meetingDays;
    }

    public String getMeetingTimes() {
        return meetingTimes;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public int getInstructorsID() {
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
            "\nInstructor’s ID     : "  + getInstructorsID() +
            "\n" +
            "\nStudent List        : "  + displayStudents("No Header");
        return printString;
    }
    
    public void addStudent(Student studentObj) {
        studentList.add(studentObj);
        
    }

    public Student locateStudent(int studentID) {
        for (Student studentObj : studentList) {
            if (studentObj.getStudentID() == studentID) {
                return studentObj;
            }
        }
        return null;
    }

    public void withdrawStudent(int studentID) {
        for (Student studentObj : studentList) {
            if (studentObj.getStudentID() == studentID) {
                studentList.remove(studentObj);

                break;
            }
        }
    }

    public void assignGrade(int studentID, int grade) {
        for (Student studentObj : studentList) {
            if (studentObj.getStudentID() == studentID) {
                studentObj.setGrade(grade);

                break;
            }
        }
    }

    public String displayStudents(String header) {
        String printStr = header == "header" ? "\n" + "Student List" : "" ;
        for (Student studentObj : studentList) {
            printStr += studentObj.toString();
        }
        return printStr;
    }




}