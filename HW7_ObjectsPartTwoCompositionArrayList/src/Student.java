/*
     * Class  	:	Student.java
     *
     * Purpose 	:	HW 7 Classes and Objects Part 2
     * 				    10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
*/

public class Student {

  private int studentID;
  private int grade;

  // Constructors:
  Student() {
    setStudentID(0);
    setGrade(0);
  }

  Student(int studentID, int grade) {
    setStudentID(studentID);
    setGrade(grade);

  }

  // Getters & Setters
  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }

  public int getStudentID() {
    return studentID;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public int getGrade() {
    return grade;
  }

  public String toString() {
    return ("\n" +
    " Student ID  : " + studentID + "\n" +
    " Grade       : " + grade + "\n");
  }

}