
/*
* Class	        :	Driver.java
*
* Purpose       :	HW10 File Operations
* 	              10979 CIS131 Prog & Problem Solv II 
*
* Developer     :	E de la Montaña
*
* Date          : 11/22/2018
*/

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args) {

    final String BOOK_FILE = "books.dat";

    RandomAccessFile bookFile = null;

    List<Book> bookList = new ArrayList<>();

    try {
      bookFile = new RandomAccessFile(BOOK_FILE, "rw");
    } catch (IOException e) {
      System.out.println("\nIOException during attempt to allocate \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }
    // Using an array in order to compile the List through iteration instead of coding multiple calls.
    Book[] books = new Book[] {
        new Book("The Dark Tower", "Donald M. Grant", "1982", "Science Fiction - Fantasy", 3.95, "Stephen King",
            "9780743254564", 2006271051, 845),
        new Book("Foundation and Earth", "Doubleday", "1986", "Science Fiction", 19.95, "Issac Asimov", "0246130474",
            87162264, 462),
        new Book("Macroscope", "Avon Books", "1969", "Science Fiction", 9.95, "Piers Anthony", "0839828993", 85021860,
            480),
        new Book("Imajica", "HarperCollins", "1991", "Fantasy", 39.95, "Clive Barker", "0060937262", 2001059130, 880),
        new Book("The Dosadi Experiment", "G. P. Putnam's Sons", "1977", "Science Fiction", 5.95, "Frank Herbert",
            "039912022X", 77003653, 336) };

    for (Book book : books) {
      bookList.add(book);
    }


    System.out.println("\nWrite bookList from List to file.\n");

    try {
      bookFile.seek(0);

      for (Book book : bookList) {
        // System.out.println(book.tooString());
        writeData(bookFile, book);
      }
    } catch (IOException e) {
      System.out.println("\nA generic IOException has occurred while attempting to write data to \"" + BOOK_FILE + "\": " + e);
    } catch (Exception e) {
      System.out.println("\nA generic Exception has occurred while attempting to write data to \"" + BOOK_FILE + "\": " + e);
    }

    System.out.println("\nIterate through "+ BOOK_FILE + " and display values for each item contained:\n");

    try {
      Book book = new Book();
      bookFile.seek(0);
      while(true) {
        readData(bookFile, book);
        // System.out.println(book.tooString());
      }

    } catch (EOFException e) {
      System.out.println("\nReached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (IOException e) {
      System.out.println("\nProbably reached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println("\nAn Exception occurred during reading of \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }

    try{
      bookFile.close();
    } catch (IOException e) {
      System.out.println("\nAn IOException occurred  while attempting to close  \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println("\nAn Exception occurred  while attempting to close  \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }

    
  }
  
  public static void writeData(RandomAccessFile bookFile, Book book)
   throws IOException, EOFException, Exception {
    bookFile.writeChars(book.getTitle());
    bookFile.writeChars(book.getAuthor());
    bookFile.writeChars(book.getPublisher());
    bookFile.writeChars(book.getPublicationDate());
    bookFile.writeChars(book.getSubject());
    bookFile.writeInt(book.getPages());
    bookFile.writeDouble(book.getPrice());
    bookFile.writeChars(book.getIsbn());
    bookFile.writeInt(book.getLibraryOfCongressNum());
  }

  public static void readData(RandomAccessFile bookFile, Book book)
    throws IOException, EOFException, Exception {
    StringBuffer sb = new StringBuffer();
    // will I have to set 'read head' at correct location for every read?
    // read Title
    for (int i = 0; i < book.getTitleLength() ; i++) {
      sb.append(bookFile.readChar());
    }
    book.setTitle(sb.toString());
    sb.setLength(0);
    // read Author
    for (int i = 0; i < book.getAuthorLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setAuthor(sb.toString());
    sb.setLength(0);
    // read Publisher
    for (int i = 0; i < book.getPublisherLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setPublisher(sb.toString());
    sb.setLength(0);
    // read PublicationDate
    for (int i = 0; i < book.getPublicationDateLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setPublicationDate(sb.toString());
    sb.setLength(0);
    // read Subject
    for (int i = 0; i < book.getSubjectLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setSubject(sb.toString());
    sb.setLength(0);
    // read Pages
    book.setPages(bookFile.readInt());
    // read Price
    book.setPrice(bookFile.readDouble());
    // read Isbn
    for (int i = 0; i < book.getIsbnLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setIsbn(sb.toString());
    sb.setLength(0);
    // read Library of Congress Number
    book.setLibraryOfCongressNum(bookFile.readInt());
    System.out.println(book.toString());
  }
}