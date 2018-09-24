/*
     * Class	:	Driver.java
     *
     * Purpose 	:	HW6 Objects Part 1 Basics
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	9/25/2018
     */

public class HW6ObjectsPart1Basics{
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

        System.out.printf("%s%n",CIS131.toString());
        
    }
}