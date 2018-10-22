/*
     * Class  	:	Periodical.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphisms
     * 				    10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/22/2018
*/

public class Periodical extends Publication{
  private String publicationFrequency; //(daily, weekly, bi-weekly, monthly, quarterly, etc.)
  private String editor;

  public Periodical(String title, String publisher, String publicationDate, String subject, String publicationFrequency, String editor) {
    super(title, publisher, publicationDate, subject);
    setPublicationFrequency(publicationFrequency);
    setEditor(editor);
  }

  public String getPublicationFrequency() {
    return this.publicationFrequency;
  }

  public void setPublicationFrequency(String publicationFrequency) {
    this.publicationFrequency = publicationFrequency;
  }

  public String getEditor() {
    return this.editor;
  }

  public void setEditor(String Editor) {
    this.editor = Editor;
  }

  @Override
  public String toString() {
    return "Periodical :" + super.toString() +
      "\nPublication Frequency       : " + getPublicationFrequency() +
      "\nEditor                      : " + getEditor();
  }
}