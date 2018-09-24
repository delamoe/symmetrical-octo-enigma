/*
     * Class	:	Class.java
     *
     * Purpose 	:	HW6 Objects Part 1 Basics
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	9/25/2018
     */

/*
HW6 Objects Part 1 Basics
You will write a Java class to represent a class section like our very own CIS 131.This class has a number of data members (aka instance variables, aka properties aka attributes) which we all know so well from looking at class schedules on the Pima web site:

1. CRN, like 20008
2. Department code, like CIS
3. Course number, like 131
4. Instructional mode, like online, on-ground or hybrid
5. Meeting days (on-ground and hybrid only, otherwise “N/A”)
6. Meeting times (on-ground and hybrid only, otherwise “N/A”)
7. Capacity (maximum number of students who can enroll in it)
8. Enrollment (number of students actually enrolled in it)
9. Instructor’s ID number (in schedules you see the instructor’s name due to a database operation called a join. Take CIS162 and 182 for more info on this.)

The class representing a class section will have all of the attributes listed above along with getter and setter methods for each of them. It will also have a default constructor that takes no parameters. This constructor will assign “” (empty string) to String attributes, 0 to int attributes and 0.0 to double attributes, if any. The ClassSection class will also have a constructor that accepts a parameter for each attribute. Lastly, it will have a toString method that returns a String containing labels and values for all of the attributes. A sample of the String produced by toString() is shown below; notice that it uses new line characters to display parts of the String on different lines:

CRN                 : 20008
Department          : CIS
Course number       : 131
Instructional mode  : Online
Meeting days        : N/A
Meeting times       : N/A
Capacity            : 30
Enrollment          : 30
Instructor’s ID     : 666

After creating the Java file for class section, you need to create an application that uses it.
We often call these applications driver programs. For our purposes, the driver program will create one instance of a class section object using its default constructor. Then it will use the object’s setter methods to assign values to its attributes. After doing this, the driver will use either println or printf to display the String returned by toString. Next, it will create a second instance of a class section object using the constructor that accepts values for all of its attributes. Again, it will it will use either println or printf to display the String returned by toString.
Provide your Java source code both the class section and the driver program. Since we have two files, compress them together into a file that contains your name then upload it to D2L.
*/

class ClassSection {
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

    String _toString() {
        String printString = "";
        printString += String.format("%nCRN                 : %d", getCRN());
        printString += String.format("%nDepartment          : %s", getDept());
        printString += String.format("%nCourse number       : %d", getCourseNumber());
        printString += String.format("%nInstructional mode  : %s", getInstructionalMode());
        printString += String.format("%nMeeting days        : %s", getMeetingDays());
        printString += String.format("%nMeeting times       : %s", getMeetingTimes());
        printString += String.format("%nCapacity            : %d", getCapacity());
        printString += String.format("%nEnrollment          : %d", getEnrollment());
        printString += String.format("%nInstructor’s ID     : %d", getInstructorsID());
        return printString;
    }

}