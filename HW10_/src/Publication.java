/*
* Class	    :	Publication.java
*
* Purpose   :	HW10 File Operations
* 				    10979 CIS131 Prog & Problem Solv II 
*
* Developer :	E de la Montaña
*
* Date		  :	11/22/2018
*/

public abstract class Publication {

  final private int TITLE_LENGTH = 21;
  final private int PUBLISHER_LENGTH = 25;
  final private int PUBLICATION_DATE_LENGTH = 4;
  final private int SUBJECT_LENGTH = 25;
  // final private int PRICE_LENGTH = 4;

  private String title;
  private String publisher;
  private String publicationDate;
  private String subject;
  private double price;

  public Publication(String title, String publisher, String publicationDate, String subject, double price) {
    setTitle(title);
    setPublisher(publisher);
    setPublicationDate(publicationDate);
    setSubject(subject);
    setPrice(price);
  }

  public StringBuffer setCorrectLength(StringBuffer sb, int correctLength) {
    if (sb.length() > correctLength) sb.setLength(correctLength);
    if (sb.length() < correctLength) {
      while (sb.length() < correctLength) sb.append(' ');
    }    
    
    return sb;
  }

  public String getTitle() {
    return this.title;
  }

  StringBuffer sb = new StringBuffer();  
  public void setTitle(String title) {
    sb.append(title);
    this.title = setCorrectLength(sb, TITLE_LENGTH).toString();
    sb.setLength(0);
  }

  public String getPublisher() {
    return this.publisher;
  }

  public void setPublisher(String publisher) {
    sb.append(publisher);
    this.publisher = setCorrectLength(sb, PUBLISHER_LENGTH).toString();
    sb.setLength(0);
  }

  public String getPublicationDate() {
    return this.publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    sb.append(publicationDate);
    this.publicationDate = setCorrectLength(sb, PUBLICATION_DATE_LENGTH).toString();
    sb.setLength(0);
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    sb.append(subject);
    this.subject = setCorrectLength(sb, SUBJECT_LENGTH).toString();
    sb.setLength(0);
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getTitleLength() {
    return TITLE_LENGTH;
  }

  public int getPublisherLength() {
    return PUBLISHER_LENGTH;
  }

  public int getPublicationDateLength() {
    return PUBLICATION_DATE_LENGTH;
  }

  public int getSubjectLength() {
    return SUBJECT_LENGTH;
  }

  public String tooString() {
    return "";
  }

  /*
   * @Override public String toString() { return
   * "\nTitle  . . . . . . . . . . . .  " + this.getTitle() +
   * "\nPublisher . . . . . . . . . . . " + this.getPublisher() +
   * "\nPublication Date . . . . . . .  " + this.getPublicationDate() +
   * "\nSubject . . . . . . . . . . . . " + this.getSubject() +
   * "\nPrice . . . . . . . . . . . . . " + this.getPrice(); }
   */
}