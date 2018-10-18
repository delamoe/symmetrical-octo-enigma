/*
*	Program		: Chapter.java
*
*	Purpose		: Defines and implements a class representing a book chapter. For brevity, it defines only two attributes of a chapter.
*
*	Developer	: F DAngelo
*/

public class Chapter
{

	private String chapterTitle;
	private int    numberOfPages;

	public Chapter()
	{
		setChapterTitle("");

		setNumberOfPages(0);
	}

	public Chapter(String chapterTitle, int numberOfPages)
	{
		setChapterTitle(chapterTitle);

		setNumberOfPages(numberOfPages);
	}

	public void setChapterTitle(String chapterTitle)
	{
		this.chapterTitle = chapterTitle;
	}

	public void setNumberOfPages(int numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}

	public String getChapterTitle() 
	{
		return chapterTitle;
	}

	public int getNumberOfPages() 
	{
		return numberOfPages;
	}

	public String toString()
	{
		return  "Chapter title  : " + getChapterTitle()  + "\n" +
			"Number of pages: " + getNumberOfPages() + "\n";
	}
}