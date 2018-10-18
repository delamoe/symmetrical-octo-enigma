
/*
     * Class	:	ClassSectionDriver.java
     *
     * Purpose 	:	HW 7 Classes and Objects Part 2
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
*/

public class ClassSectionDriver {
    public static void main(String[] args) {

        ClassSection CIS131 = new ClassSection();
        // uncomment to test initial values
        // System.out.printf("%s%n", CIS131.toString());

        CIS131.setCRN(20008);
        CIS131.setDept("CIS");
        CIS131.setCourseNumber(131);
        CIS131.setInstructionalMode("Online");
        CIS131.setMeetingDays("N/A");
        CIS131.setMeetingTimes("N/A");
        CIS131.setCapacity(30);
        CIS131.setEnrollment(30);
        CIS131.setInstructorsID(666);

        Student student_001 = new Student(1, 0);
        Student student_002 = new Student(2, 0);
        Student student_003 = new Student(3, 0);
        Student student_004 = new Student(4, 0);
        CIS131.addStudent(student_001);
        CIS131.addStudent(student_002);
        CIS131.addStudent(student_003);
        CIS131.addStudent(student_004);

        System.out.printf("%s%n", CIS131.toString());
        
        // Assign grades
        for (int i = 1; i < 5; i++){
            CIS131.assignGrade(i, i);
        }
        
        System.out.printf(CIS131.displayStudents("header"));

        CIS131.withdrawStudent(1);

        System.out.printf(CIS131.displayStudents("header"));

    }
}