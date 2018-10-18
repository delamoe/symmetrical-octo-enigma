/*
*	Program		: Book.java
*
*	Purpose		: Defines and implements a class representing a Book. For brevity, it defines only four attributes of a book.
*
*	Developer	: F DAngelo
*/

import java.util.List; //.ArrayList;
import java.util.ArrayList;

public class Employee {

	private String isbn;
	private String title;
	private String subject;
	private double price;

	public Employee() 
	{
		this("", "", "", 0.0); // Invoke the four parameter constructor.
	}

	public Employee(String isbn, String title, String subject, double price)
	{
		setIsbn(isbn);
		setTitle(title);
		setSubject(subject);
		setPrice(price);
                
               /* chapterList = new ArrayList<Chapter>(); // We'll instantiate it in the constructor.
*/	}


	void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	void setTitle(String title)
	{
		this.title = title;
	}

	void setSubject(String subject)
	{
		this.subject = subject;
	}

	void setPrice(double price)
	{
		this.price = price;
	}

	String getIsbn() 
	{
		return isbn;
	}

	String getTitle() 
	{
		return title;
	}

	String getSubject() 
	{
		return subject;
	}

	double getPrice() 
	{
		return price;
	}

	public String toString() 
	{
		String objectState = "" ;

		objectState += 
						"ISBN    : " + getIsbn()    + "\n" +
		    		"Title   : " + getTitle()   + "\n" +
		    		"Subject : " + getSubject() + "\n" +
		    		"Price   : " + getPrice()   + "\n";

	/*objectState +=  "\nChapter list: " + "\n";

	for (int i = 0; i < chapterList.size(); i++)
	{
		objectState += chapterList.get(i).toString();
	}*/

	return objectState ;
	}

};
