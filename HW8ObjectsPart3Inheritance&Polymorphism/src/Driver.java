/*
     * Class	:	Driver.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphism
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
*/

public class Driver {
  public static void main(String[] args) {

    Book book_001 = new Book("The Dark Tower", "Stephen King", "9780743254564", 2006271051, 845);
    Book book_002 = new Book("The Dosadi Experiment", "Frank Herbert", "039912022X", 77003653, 336);
    Book book_003 = new Book("Foundation and Earth", "Issac Asimov", "0246130474", 87162264, 462);
    Book book_004 = new Book("Macroscope", "Piers Anthony", "0839828993", 85021860, 480);
    Book book_005 = new Book("Imajica", "Clive Barker", "0060937262", 2001059130, 880);
    
    Periodical period_001 = new Periodical("quarterly", "Ed Sloe");
    Periodical period_002 = new Periodical("monthly", "Laurdly Maddox");
    Periodical period_003 = new Periodical("semi-annually", "Margret Munplenktns");

    bookList.toString();
    PeriodicalList.toString();
  }
}