
/*
* Class      : Driver.java
*
* Purpose    : HW10 - File Operations
*              10979 CIS131 Prog & Problem Solv II
*
* Developer  : E de la Montaña
*
* Date       : 10/25/2018
* 
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args) {

    final String BOOK_FILE = "BookFile.dat";

    RandomAccessFile bookFile = null;

    List<Publication> publications = new ArrayList<>();

    try {
      bookFile = new RandomAccessFile(BOOK_FILE, "rw");
    }

    catch (IOException e) {
      System.out.println("\n IOExeption ocurred while attempting to allocate the BookFile.");
    }

    Publication[] publicationEntries = new Publication[] {
        new Book("The Dark Tower", "Donald M. Grant", "1982", "Fantasy", "Stephen King", "9780743254564", 2006271051, 845),
        new Book("Foundation and Earth", "Doubleday", "1986", "Science Fiction", "Issac Asimov", "0246130474", 87162264, 462),
        new Book("Macroscope", "Avon Books", "1969", "Science Fiction", "Piers Anthony", "0839828993", 85021860, 480),
        new Book("Imajica", "HarperCollins", "1991", "Fantasy", "Clive Barker", "0060937262", 2001059130, 880),
        new Book("The Dosadi Experiment", "G. P. Putnam's Sons", "1977", "Science Fiction", "Frank Herbert", "039912022X", 77003653, 336)
          };


    for (Publication publication : publicationEntries) {
      publications.add(publication);
    }

    for (Publication publication : publications) {
      // System.out.println(publication.toString() + "\n");
      bookFile.add(publication);
    }
    
  }
}