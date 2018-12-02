
/*
* Class	        :	Driver.java
*
* Purpose       :	HW10 File Operations
* 	              10979 CIS131 Prog & Problem Solv II 
*
* Developer     :	E de la Montaña
*
* Date          : 11/27/2018
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
      // in case of residual file, truncate
      bookFile.setLength(0);
    } catch (IOException e) {
      System.out.println("\nIOException during attempt to allocate \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }
    // Instantiating an array in order to compile the List 
    // through iteration instead of coding multiple calls.
    Book[] books = new Book[] {
        new Book(1, "The Dark Toower", "Donald M. Grant", "1982", "Science Fiction - Fantasy", 3.95, "Stephen King",
            "9780743254564", 2006271051, 845),
        new Book(2, "Foundation and Earth", "Doubleday", "1986", "Science Fiction", 19.95, "Isaac Asimov", "0246130474",
            87162264, 462),
        new Book(3, "Macroscope", "Avon Books", "1969", "Science Fiction", 9.95, "Piers Anthony", "0839828993",
            85021860, 480),
        new Book(4, "Imajica", "HarperCollins", "1991", "Fantasy", 39.95, "Clive Barker", "0060937262", 2001059130,
            880),
        new Book(5, "The Dosadi Experiment", "G. P. Putnam's Sons", "1977", "Science Fiction", 5.95, "Frank Herbert",
            "039912022X", 77003653, 336) };

    for (Book book : books) {
      bookList.add(book);
    }

    System.out.println("\nWrite data to bookList (" + BOOK_FILE + ") from List to file.");

    try {
      long startByte = 0;
      for (Book book : bookList) {
        writeData(bookFile, book, startByte);
        startByte = bookFile.getFilePointer();
      }

      System.out.println("\r==> " + bookFile.length() + " Bytes have been written to file, " + BOOK_FILE + " (" + bookFile.toString() + ".)");
    } catch (IOException e) {
      System.out.println("\nA generic IOException has occurred while attempting to write data to \"" + BOOK_FILE
          + "\": " + e.toString());
    } catch (Exception e) {
      System.out.println("\nA generic Exception has occurred while attempting to write data to \"" + BOOK_FILE + "\": "
          + e.toString());
    }

    System.out.println("\nIterate through " + BOOK_FILE + " and display values for each item contained:\n");

    try {
      Book book = new Book();
      long startByte = 0;
      while (true) {
        readData(bookFile, book, startByte);
        startByte = bookFile.getFilePointer();
      }

    } catch (EOFException e) {
      System.out.println("\nReached EOF on \"" + BOOK_FILE + "\": " + e.toString() + ".\n");
    } catch (IOException e) {
      System.out.println("\nProbably reached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println("\nAn Exception occurred during reading of \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }

    try {
      long bookToAlter = 3;
      Book book = new Book();
      System.out.println("\nOriginal Book " + bookToAlter + "\n");
      readData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));
      book.setPrice(25.95);
      writeData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));
      System.out.println("\nUpdated price for Book " + bookToAlter + "\n");
      readData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));

    } catch (EOFException e) {
      System.out.println("\nReached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (IOException e) {
      System.out.println("\nProbably reached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println("\nAn Exception occurred during reading of \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }

    try {
      long bookToAlter = 1;
      Book book = new Book();
      System.out.println("\nOriginal Book " + bookToAlter + "\n");
      readData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));
      book.setTitle("The Dark Tower");
      writeData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));
      System.out.println("\nUpdated title for Book " + bookToAlter + "\n");
      readData(bookFile, book, ((bookToAlter - 1) * book.getRecordLength()));

    } catch (EOFException e) {
      System.out.println("\nReached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (IOException e) {
      System.out.println("\nProbably reached EOF on \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println("\nAn Exception occurred during reading of \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }

    try {
      bookFile.close();
    } catch (IOException e) {
      System.out.println(
          "\nAn IOException occurred  while attempting to close  \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    } catch (Exception e) {
      System.out.println(
          "\nAn Exception occurred  while attempting to close  \"" + BOOK_FILE + "\": " + e.getMessage() + ".\n");
    }
  }
  
  public static void writeData(RandomAccessFile bookFile, Book book, long startByte)
  throws IOException, EOFException, Exception {
    bookFile.seek(startByte);
    bookFile.writeLong(book.getBookID());
    bookFile.writeChars(book.getTitle());
    bookFile.writeChars(book.getAuthor());
    bookFile.writeChars(book.getPublisher());
    bookFile.writeChars(book.getyearPublished());
    bookFile.writeChars(book.getSubject());
    bookFile.writeInt(book.getPages());
    bookFile.writeDouble(book.getPrice());
    bookFile.writeChars(book.getIsbn());
    bookFile.writeInt(book.getLibraryOfCongressNum());
  }
  
  public static void readData(RandomAccessFile bookFile, Book book, long startByte)
  throws IOException, EOFException, Exception {
    bookFile.seek(startByte);
    StringBuffer sb = new StringBuffer();
    book.setBookID(bookFile.readLong());
    for (int i = 0; i < book.getTitleLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setTitle(sb.toString());
    sb.setLength(0);
    for (int i = 0; i < book.getAuthorLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setAuthor(sb.toString());
    sb.setLength(0);
    for (int i = 0; i < book.getPublisherLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setPublisher(sb.toString());
    sb.setLength(0);
    for (int i = 0; i < book.getyearPublishedLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setyearPublished(sb.toString());
    sb.setLength(0);
    for (int i = 0; i < book.getSubjectLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setSubject(sb.toString());
    sb.setLength(0);
    book.setPages(bookFile.readInt());
    book.setPrice(bookFile.readDouble());
    for (int i = 0; i < book.getIsbnLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setIsbn(sb.toString());
    sb.setLength(0);
    book.setLibraryOfCongressNum(bookFile.readInt());
    System.out.println(book.toString());
  }
}