
/*
* Class	        :	Book.java
*
* Purpose       :	HW10 File Operations
* 	                10979 CIS131 Prog & Problem Solv II 
*
* Developer     :	E de la Montaña
*
* Date          :       11/22/2018
*/

class Book extends Publication {

	final private int AUTHOR_LENGTH = 19;
	final private int ISBN_LENGTH = 10;
	// final private int LIBRARY_OF_CONGRESS_NUM_LENGTH = 8;
	// final private int PAGES_LENGTH = 4;

	private String author;
	private String isbn;
	private int libraryOfCongressNum;
	private int pages;

	private long recordLength = 0;

	
	public Book() {
		super(0, "", "", "", "", 0);
		setBookID(0);
		setAuthor("");
		setIsbn("");
		setLibraryOfCongressNum(0);
		setPages(0);
		setRecordLength();
	}
	
	public Book(long bookID, String title, String publisher, String yearPublished, String subject, double price, String author,
	String isbn, int libraryOfCongressNum, int pages) {
		super(bookID, title, publisher, yearPublished, subject, price);
		setBookID(bookID);
		setAuthor(author);
		setIsbn(isbn);
		setLibraryOfCongressNum(libraryOfCongressNum);
		setPages(pages);
		setRecordLength();
	}
	
	public void setRecordLength(/* long recordLength */) {
		// this.recordLength = recordLength;
		recordLength = (Long.SIZE / 8) + (getTitleLength() * 2) + (getAuthorLength() * 2) + (getPublisherLength() * 2)	+ (getyearPublishedLength() * 2) + (getSubjectLength() * 2)	+ (Integer.SIZE / 8) + (Double.SIZE / 8) + (getIsbnLength() * 2) + (Integer.SIZE / 8);
	}

	public long getRecordLength() {
		return recordLength;
	}
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		sb.append(author);
		this.author = setCorrectLength(sb, AUTHOR_LENGTH).toString();
		sb.setLength(0);
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		sb.append(isbn);
		this.isbn = setCorrectLength(sb, ISBN_LENGTH).toString();
		sb.setLength(0);
	}

	public int getLibraryOfCongressNum() {
		return this.libraryOfCongressNum;
	}

	public void setLibraryOfCongressNum(int libraryOfCongressNum) {
		this.libraryOfCongressNum = libraryOfCongressNum;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getAuthorLength() {
		return AUTHOR_LENGTH;
	}

	public int getIsbnLength() {
		return ISBN_LENGTH;
	}

	/* public static String readString(Book ) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < book.getTitleLength(); i++) {
      sb.append(bookFile.readChar());
    }
    book.setTitle(sb.toString());
		sb.setLength(0);
	} */

	public String tooString() {
		return "Book: " + getBookID() + /* super.toString() + */
				"\nTitle . . . . . . . . . . . . . " + this.getTitle() + "\nAuthor . . . . . . . . . . . .  " + this.author
				+ "\nPublisher . . . . . . . . . . . " + this.getPublisher() + "\nPublication Date . . . . . . .  "
				+ this.getyearPublished() + "\nSubject . . . . . . . . . . . . " + this.getSubject()
				+ "\nPages. . . . . . . . . . . . .  " + this.pages + " Pp" + "\nPrice . . . . . . . . . . . . . $"
				+ this.getPrice() + "\nISBN . . . . . . . . . . . . .  " + this.isbn + "\nLibrary of Congress Number. . . "
				+ this.libraryOfCongressNum + "\n";
	}

	@Override
	public String toString() {
		return "Book: " + getBookID() + /* super.toString() + */
				"\nTitle . . . . . . . . . . . . . " + this.getTitle() +
				"\nAuthor . . . . . . . . . . . .  " + this.author +
				"\nPublisher . . . . . . . . . . . " + this.getPublisher() +
				"\nPublication Date . . . . . . .  " + this.getyearPublished() +
				"\nSubject . . . . . . . . . . . . " + this.getSubject() +
				"\nPages. . . . . . . . . . . . .  " + Integer.toString(this.pages) + " Pp" +
				"\nPrice . . . . . . . . . . . . . $" + Double.toString(this.getPrice()) +
				"\nISBN . . . . . . . . . . . . .  " + this.isbn +
				"\nLibrary of Congress Number. . . " + Integer.toString(this.libraryOfCongressNum) +
				"\n"; 		
	}
}