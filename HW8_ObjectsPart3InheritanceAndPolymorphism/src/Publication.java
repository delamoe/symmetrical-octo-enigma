/*
* Class	    :	Publication.java
*
* Purpose   :	HW8 Objects Part 3 Inheritance and Polymorphism
* 				    10979 CIS131 Prog & Problem Solv II 
*
* Developer :	E de la Montaña
*
* Date		  :	10/25/2018
*/

public abstract class Publication {
  
  private String title;
  private String publisher;
  private String publicationDate;
  private String subject;

  public Publication(String title, String publisher, String publicationDate, String subject) {
    setTitle(title);
    setPublisher(publisher);
    setPublicationDate(publicationDate);
    setSubject(subject);
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getPublicationDate() {
    return this.publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return 
    "\nTitle . . . . . . . . . . . . " + this.getTitle() +
    "\nPublisher. . . . . . . . . . ." + this.getPublisher() +
    "\nPublication Date. . . . . . . " + this.getPublicationDate() +
    "\nSubject. . . . . . . . . . . ." + this.getSubject();
  }
}