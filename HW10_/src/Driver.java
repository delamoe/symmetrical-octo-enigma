/*
     * Class	  :	Driver.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphism
     *            10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		  :	10/28/2018
*/

import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args) {
    
    List<Publication> publications = new ArrayList<>();
    
    Publication[] publicationEntries = new Publication[] { 
      new Book("The Dark Tower", "Donald M. Grant", "1982", "Science Fiction - Fantasy", "Stephen King", "9780743254564", 2006271051, 845), 
      new Book("Foundation and Earth", "Doubleday", "1986", "Science Fiction", "Issac Asimov", "0246130474", 87162264, 462), 
      new Book("Macroscope", "Avon Books", "1969", "Science Fiction", "Piers Anthony", "0839828993", 85021860, 480),
      new Book("Imajica", "HarperCollins", "1991", "Fantasy", "Clive Barker", "0060937262", 2001059130, 880), 
      new Book("The Dosadi Experiment", "G. P. Putnam's Sons", "1977", "Science Fiction", "Frank Herbert", "039912022X", 77003653, 336)
    };

    /* for (Publication publication : publicationEntries) {
      publications.add(publication);
      System.out.println(publication.toString() + "\n");
    } */

    for (Publication publication : publicationEntries) {
      publications.add(publication);
    }
    
    for (Publication publication : publications) {
      System.out.println(publication.toString() + "\n");
    }
  }
}