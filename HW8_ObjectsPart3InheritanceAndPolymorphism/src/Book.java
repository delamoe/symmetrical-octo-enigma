
/*
     * Class	:	Book.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphisms
     * 			10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date	:	10/25/2018
     */

class Book extends Publication {

        private String author;
        private String isbn;
        private int libraryOfCongressNum;
        private int pages;

        public Book(String title, String publisher, String publicationDate, String subject, String author, String isbn,
                        int libraryOfCongressNum, int pages) {
                super(title, publisher, publicationDate, subject);
                setAuthor(author);
                setIsbn(isbn);
                setLibraryOfCongressNum(libraryOfCongressNum);
                setPages(pages);
        }

        public String getAuthor() {
                return this.author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getIsbn() {
                return this.isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
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

        public String toString() {
                return "Book :" + super.toString() +
                "\nAuthor. . . . . . . . . . . . " + author +
                "\nISBN . . . . . . . . . . . . ." + isbn +
                "\nLibrary of Congress Number. . " + libraryOfCongressNum +
                "\nPages. . . . . . . . . . . . ." + pages;
        }
}