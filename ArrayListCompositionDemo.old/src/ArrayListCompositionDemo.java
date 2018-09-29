/*
*	Program		: ArrayListCompositionDemo.java
*
*	Purpose		: To demonstrate how to use an ArrayList of objects as a variable within a class.
*			  This example creates an ArrayList of objects of the Book class. Then it adds Chapter
*			  objects to the Chpater ArrayLists within them.
*
*	Developer	: F DAngelo
*/


import java.util.List; //.ArrayList;
import java.util.ArrayList;

public class ArrayListCompositionDemo
{

    public static void main(String[] args)
    {
            // Declare the book vector:
            List <Book>bookList = new ArrayList<Book>();

            // Add books to the book vector:
            bookList.add(new Book("123-456", "Intro to C++", "C++ Programming", 75.00));
            bookList.add(new Book("234-567", "Intro to Database", "Database", 80.00));
            bookList.add(new Book("345-678", "Intro to Java", "Java Programming", 70.00));

            // Declare and add chapters to the first book:
            (bookList.get(0)).addChapter(new Chapter("Introduction", 20));
            (bookList.get(0)).addChapter(new Chapter("C++ Assignment statements", 30));
            (bookList.get(0)).addChapter(new Chapter("C++ Selection structures", 35));

            // Declare and add chapters to the second book:
            bookList.get(1).addChapter(new Chapter("Introduction", 20));
            bookList.get(1).addChapter(new Chapter("Rows, Columns and Tables", 30));
            bookList.get(1).addChapter(new Chapter("Keys", 35));

            // Declare and add chapters to the third book:
            bookList.get(2).addChapter(new Chapter("Introduction", 20));
            bookList.get(2).addChapter(new Chapter("Java Assignment statements", 30));
            bookList.get(2).addChapter(new Chapter("Java Selection structures", 35));

            displayBookList(bookList);


            return;

    }

    private static void displayBookList( List<Book> books)
    {
             System.out.println("\n **** The older way to iterate through a list. ****\n");
            for (int i = 0; i < books.size(); i++)
            {
                    System.out.println( books.get(i).toString() + "\n") ;
            }
            
            System.out.println("\n **** The newer way to iterate through a list. ****\n");
            // forEach
            for ( Book bookObj: books )
            {
                    System.out.println( bookObj.toString() + "\n") ;
            }
    }
}