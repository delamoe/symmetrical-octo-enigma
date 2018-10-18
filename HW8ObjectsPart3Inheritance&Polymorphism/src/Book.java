
/*
     * Class	:	Book.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphisms
     * 				10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
     */

public class Book {
        private String title = "";
        private String Author = "";
        private String isbn = "";
        private int libraryOfCongressNum = 0;
        private int pages = 0;

        public Book(String title, String Author, String isbn, int libraryOfCongressNum, int pages) {
                this.title = title;
                this.Author = Author;
                this.isbn = isbn;
                this.libraryOfCongressNum = libraryOfCongressNum;
                this.pages = pages;
        }

        public String getTitle() {
                return this.title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return this.Author;
        }

        public void setAuthor(String Author) {
                this.Author = Author;
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

        @Override
        public String toString() {
                return "{" +
                        " title='" + getTitle() + "'" +
                        ", Author='" + getAuthor() + "'" +
                        ", isbn='" + getIsbn() + "'" +
                        ", libraryOfCongressNum='" + getLibraryOfCongressNum() + "'" +
                        ", pages='" + getPages() + "'" +
                        "}";
        }

}